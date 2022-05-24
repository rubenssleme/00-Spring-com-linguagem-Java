package avaliacao.base.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    private static final String BEARER_SCHEME = "Bearer";


    @Bean
    public OpenAPI api() {
        OpenAPI api = new OpenAPI()
                .components(addComponents())
                .addSecurityItem(new SecurityRequirement().addList(BEARER_SCHEME))
                ;
        return api;
    }

    private Components addComponents() {
        Components components = new Components();
        components.addSecuritySchemes(BEARER_SCHEME, this.getBearerScheme());
        return components;
    }

    private SecurityScheme getBearerScheme() {
        return new SecurityScheme()
                .name("bearerScheme")
                .type(SecurityScheme.Type.HTTP)
                .scheme(BEARER_SCHEME);
    }
}
