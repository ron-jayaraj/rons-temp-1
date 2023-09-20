package com.ron.sell.online.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!prod")
@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI openAPI(@Value("${server.servlet.contextPath}") String contextPath) {
                return new OpenAPI()
                                .addServersItem(new Server().url(contextPath))

                                .info(new Info()
                                                .title("rons-test-springboot-app-setup-and-twitter-client-api-example")
                                                .version("1.0")
                                                .description("<a href='https://ronsYamlSpec.yaml' rel='noopener noreferrer' class='link'><span class='url'>\n YAML Specification </span></a>")

                                );
        }

}
