package com.malexj.training_course.props.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan("com.malexj.training_course.props")
public class PropsPropertySourcesConfiguration {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySources() {
    var configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setLocation(new ClassPathResource("application.properties"));
    return configurer;
  }
}
