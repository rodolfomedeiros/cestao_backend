package com.devroods.cestao_backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringBootConfiguration {
  
  @Bean
  public WebMvcConfigurer configurer(){
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
          .allowedMethods("GET");
      }
    };
  }

}