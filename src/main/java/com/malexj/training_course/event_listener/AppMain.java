package com.malexj.training_course.event_listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(EvenListenerConfiguration.class);
    
  }
}
