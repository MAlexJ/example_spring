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
      @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Shop.class),
      @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ShopLifeCycleConfiguration.class)
    })
public class PhoneLifeCycleConfiguration {

  @Bean(initMethod = "init", destroyMethod = "destroy")
  public Phone phone() {
    return new Phone();
  }
}
