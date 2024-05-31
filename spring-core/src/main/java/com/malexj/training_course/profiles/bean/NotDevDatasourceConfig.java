package com.malexj.training_course.profiles.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!dev")
@Component("myBean")
public class NotDevDatasourceConfig {

  @Value("${spring.profiles.active:}")
  private String activeProfile;

  public String getActiveProfile() {
    return activeProfile;
  }
}
