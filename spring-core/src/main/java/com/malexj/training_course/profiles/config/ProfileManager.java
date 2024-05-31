package com.malexj.training_course.profiles.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProfileManager {

  @Autowired private Environment environment;

  public String[] getActiveProfiles() {
    return environment.getActiveProfiles();
  }
}
