package avaliacao.base.configs;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import avaliacao.base.handlers.LogHandlerInterceptor;
import avaliacao.base.serializers.LocalDateDeserializer;
import avaliacao.base.serializers.LocalDateSerializer;
import avaliacao.base.serializers.LocalDateTimeDeserializer;
import avaliacao.base.serializers.LocalDateTimeSerializer;
import avaliacao.base.serializers.LocalTimeDeserializer;
import avaliacao.base.serializers.LocalTimeSerializer;
import avaliacao.base.services.LogService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final LogService logService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor(logService));
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));
    }

    @Bean
    public static ObjectMapper getJsonMapper() {
        return new ObjectMapper()
           	.setSerializationInclusion(Include.NON_NULL)
           	.setSerializationInclusion(Include.NON_EMPTY)
            .registerModule(new SimpleModule()
                .addSerializer(LocalDate.class, new LocalDateSerializer())
                .addSerializer(LocalTime.class, new LocalTimeSerializer())
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer())
                .addDeserializer(LocalDate.class, new LocalDateDeserializer())
                .addDeserializer(LocalTime.class, new LocalTimeDeserializer())
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer())
            );
    }
}
