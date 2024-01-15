package com.malexj.training_course.postprocessor.bean;

import org.springframework.stereotype.Component;

@Component
public class Customer {

  private boolean isReady;

  public String state() {
    if (isReady) {
      return "Ready";
    }
    return "Not ready";
  }
}
