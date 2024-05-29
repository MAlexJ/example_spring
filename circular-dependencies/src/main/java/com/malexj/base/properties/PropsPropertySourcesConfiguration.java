package com.malexj.base.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class PropsPropertySourcesConfiguration {

  @Bean
  public PropertySourcesPlaceholderConfigurer propertySources() {
    var configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setLocation(new ClassPathResource("application.properties"));
    return configurer;
  }
}
