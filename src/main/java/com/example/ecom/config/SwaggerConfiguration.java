package com.example.ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "ECOM Service",
                "ECOM Service REST API Documentation.",
                "API TOS",
                "http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open",
                new Contact("Software Team", "www.dialog.lk", "SoftwareTeam@dialog.lk"),
                "Apache License Version 2.0", "https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE",
                Collections.emptyList());
    }
}
