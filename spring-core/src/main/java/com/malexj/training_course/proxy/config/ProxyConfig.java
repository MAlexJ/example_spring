package com.malexj.training_course.proxy.config;

import com.malexj.training_course.proxy.bean.Customer;
import com.malexj.training_course.proxy.bean.IWaiter;
import com.malexj.training_course.proxy.bean.Waiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.malexj.training_course.proxy")
public class ProxyConfig {

  @Bean
  public IWaiter john() {
    return new Waiter("John");
  }

  @Bean
  public Customer alex() {
    return new Customer("Alex");
  }

  @Bean
  public Customer anna() {
    return new Customer("Anna");
  }

  @Bean
  public Customer max() {
    return new Customer("Max");
  }
}
