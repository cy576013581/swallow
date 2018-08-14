package com.cy.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Instant;
import java.time.LocalDate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


  /**
   * Swagger api docket
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.regex("/system/.*"))
      .build()
      .pathMapping("/")
      .directModelSubstitute(LocalDate.class, String.class)
      .directModelSubstitute(Instant.class, String.class)
      .genericModelSubstitutes(ResponseEntity.class);
  }
}
