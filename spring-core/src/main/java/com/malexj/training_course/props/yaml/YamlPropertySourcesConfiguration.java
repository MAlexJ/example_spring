package com.malexj.training_course.props.yaml;

import java.util.Objects;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan("com.malexj.training_course.props")
public class YamlPropertySourcesConfiguration {

  /**
   * We use static
   */
  @Bean
  public static YamlPropertiesFactoryBean yamlPropertiesFactory() {
    YamlPropertiesFactoryBean propertiesFactory = new YamlPropertiesFactoryBean();
    propertiesFactory.setResources(new ClassPathResource("application.yaml"));
    return propertiesFactory;
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySources(
      YamlPropertiesFactoryBean propertiesFactory) {
    var configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setProperties(Objects.requireNonNull(propertiesFactory.getObject()));
    return configurer;
  }
}
