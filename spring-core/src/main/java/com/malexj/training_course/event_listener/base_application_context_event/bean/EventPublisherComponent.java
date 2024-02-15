package com.malexj.training_course.event_listener.base_application_context_event.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherComponent {

  private final ApplicationEventPublisher publisher;

  public void publishEvent(String event) {
    var stringPayloadEvent = new PayloadApplicationEvent<>(event, "Test payload87!");
    this.publisher.publishEvent(stringPayloadEvent);
  }
}
