package com.malexj.training_course.event_listener.base.events;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedListener extends AbstractClass
    implements ApplicationListener<ContextStartedEvent> {

  public void onApplicationEvent(ContextStartedEvent event) {
    println(">>> Application started: " + event.getSource());
  }
}
