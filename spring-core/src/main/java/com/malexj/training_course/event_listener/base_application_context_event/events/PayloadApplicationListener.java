package com.malexj.training_course.event_listener.base_application_context_event.events;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PayloadApplicationListener extends AbstractClass {

  /** Handle context even: Payload */
  @EventListener(PayloadApplicationEvent.class)
  public <T> void handlePayloadApplicationEvent(PayloadApplicationEvent<T> event) {
    println("", "2. PayloadApplicationEvent:", "payload:", event.getPayload());
  }
}
