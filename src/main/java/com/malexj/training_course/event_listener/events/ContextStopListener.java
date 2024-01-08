package com.malexj.training_course.event_listener.events;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextStopListener extends AbstractClass {

  @EventListener(ContextStoppedEvent.class)
  public void handleContext(ContextStoppedEvent event) {
    println("  >>> Application context stopped: " + event.getSource());
  }
}
