package com.malexj.training_course.life_cycle.configuration;

import com.malexj.training_course.life_cycle.bean.Note;
import com.malexj.training_course.life_cycle.bean.Phone;
import com.malexj.training_course.life_cycle.bean.Shop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "com.malexj.training_course.life_cycle",
    excludeFilters = {
      @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Note.class),
      @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Phone.class),
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          value = PhoneLifeCycleConfiguration.class)
    })
public class ShopLifeCycleConfiguration {

  @Bean
  public Shop shop() {
    return new Shop();
  }
}
