package com.malexj.training_course.aware.config;

import com.malexj.training_course.aware.bean.Chef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.malexj.training_course.aware")
public class AwareConfiguration {

  @Bean
  public Chef restaurantChef() {
    return new Chef();
  }
}
