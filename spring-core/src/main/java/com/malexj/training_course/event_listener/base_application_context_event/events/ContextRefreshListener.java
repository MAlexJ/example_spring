package com.malexj.training_course.event_listener.base_application_context_event.events;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshListener extends AbstractClass
    implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    println("1. ContextRefreshedEvent: ", event.getSource().getClass().getName());
  }
}
