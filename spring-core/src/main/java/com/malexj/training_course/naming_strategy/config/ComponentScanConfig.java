package com.malexj.training_course.naming_strategy.config;

import com.malexj.training_course.naming_strategy.bean.AuditService;
import com.malexj.training_course.naming_strategy.bean.BeanWithValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.malexj.training_course.naming_strategy")
public class ComponentScanConfig {

  @Bean
  public AuditService auditBean() {
    return new AuditService();
  }

  @Bean("myBean")
  public BeanWithValue beanWithValue() {
    return new BeanWithValue();
  }
}
