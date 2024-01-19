package sg.edu.nus.iss.day27workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI openApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("PAF Day 27 and 28")
                        .description("day 27 API")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Darryl")
                                .url("http://localhost:8080")
                                .email("darryl1975@gmail.com"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#")));
    }
}
