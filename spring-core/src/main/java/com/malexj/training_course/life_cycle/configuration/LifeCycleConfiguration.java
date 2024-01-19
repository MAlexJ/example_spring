package com.malexj.training_course.life_cycle.configuration;

import com.malexj.training_course.life_cycle.bean.Phone;
import com.malexj.training_course.life_cycle.bean.Shop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.malexj.training_course.life_cycle")
public class LifeCycleConfiguration {

  @Bean(initMethod = "init", destroyMethod = "destroy")
  public Phone phone() {
    return new Phone();
  }

  @Bean
  public Shop shop() {
    return new Shop();
  }
}
