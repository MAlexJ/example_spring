package com.malexj.training_course.event_listener.base_application_context_event.events;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedListener extends AbstractClass
    implements ApplicationListener<ContextStartedEvent> {

  public void onApplicationEvent(ContextStartedEvent event) {
    println("", "3. ContextStartedEvent: ", event.getSource().getClass().getName());
  }
}
