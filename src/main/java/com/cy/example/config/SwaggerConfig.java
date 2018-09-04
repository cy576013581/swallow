package com.cy.example.config;

import com.cy.example.controller.FileController;
import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
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
    /*
    针对RestController注解的类和ResponseBody注解的方法才生成Swaager的API，
    并且排除了特定的类
     */
    Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
      @Override
      public boolean apply(RequestHandler input) {
        Class<?> declaringClass = input.declaringClass();
        if (declaringClass == BasicErrorController.class ||
                declaringClass == FileController.class )// 排除
          return false;
        if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
          return true;
        if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
          return true;
        return false;
      }
    };
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(predicate)
      .paths(PathSelectors.regex("/system/.*"))
      .build()
      .pathMapping("/")
      .directModelSubstitute(LocalDate.class, String.class)
      .directModelSubstitute(Instant.class, String.class)
      .genericModelSubstitutes(ResponseEntity.class);
  }
}
