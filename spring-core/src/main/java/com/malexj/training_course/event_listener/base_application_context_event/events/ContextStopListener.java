package com.malexj.training_course.event_listener.base_application_context_event.events;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextStopListener extends AbstractClass {

  /** Handle context even: stopped */
  @EventListener(ContextStoppedEvent.class)
  public void handleContext(ContextStoppedEvent event) {
    println("4. ContextStoppedEvent:", event.getSource().getClass().getName());
  }
}
