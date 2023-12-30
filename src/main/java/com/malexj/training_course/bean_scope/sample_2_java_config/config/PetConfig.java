package com.malexj.training_course.bean_scope.sample_2_java_config.config;

import com.malexj.training_course.bean_scope.sample_2_java_config.bean.CatSingleton;
import com.malexj.training_course.bean_scope.sample_2_java_config.bean.DogPrototype;
import com.malexj.training_course.bean_scope.sample_2_java_config.bean.PetFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.malexj.training_course.bean_scope.sample_2_java_config")
public class PetConfig {

  @Bean
  public PetFactory factory() {
    return new PetFactory();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  public CatSingleton catSingleton() {
    return factory().createCat();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public DogPrototype dogPrototype() {
    return factory().createDog();
  }
}
