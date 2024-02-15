package com.malexj.training_course.event_listener.base_application_context_event.events;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextClosedListener extends AbstractClass {

  /** Handle context even: closed */
  @EventListener(ContextClosedEvent.class)
  public void handleContextStoppedEvent(ContextClosedEvent event) {
    println("", "5. ContextClosedEvent:", event.getSource().getClass().getName());
  }
}
