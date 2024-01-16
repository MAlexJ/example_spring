package com.malexj.training_course.aware.bean;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class User implements EnvironmentAware {

  private Environment environment;

  public String javaVendorOsEnv() {
    return environment.getProperty("java.vendor");
  }

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }
}
