package com.malexj.training_course.profiles.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.malexj.training_course.profiles")
public class SetActiveProfilesConfig {

  @Autowired private ConfigurableEnvironment env;

  @PostConstruct
  public void init() {
    env.setActiveProfiles("dev", "test");
  }
}
