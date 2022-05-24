package avaliacao.hackathon;

import avaliacao.base.properties.CorsProperties;
import avaliacao.hackathon.model.dto.ContextDTO;
import avaliacao.hackathon.model.enuns.ContextStatus;
import avaliacao.hackathon.service.ContextService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@ComponentScan({"avaliacao"})
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableConfigurationProperties({CorsProperties.class})
@EnableAsync
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    CommandLineRunner runner(ContextService service) {
        return args -> {
            ContextDTO contextDTO = ContextDTO.builder()
                .Id(1L)
                .name("Hackathon Summer")
                .startDay(LocalDateTime.now())
                .endDay(LocalDateTime.of(LocalDate.now().plus(300, ChronoUnit.MONTHS), LocalTime.now()))
                .status(ContextStatus.Finalized.getStatus())
                .build();

            System.out.println(service.createSimpleContext(contextDTO));

            System.out.println(service.getContexts());
        };
    }
}
