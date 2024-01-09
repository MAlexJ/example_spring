package com.malexj.training_course.event_listener.custom.bean;

import com.malexj.training_course.event_listener.custom.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Restaurant {

  private final ApplicationEventPublisher publisher;

  public void placeOrder(String order) {
    var event = new OrderEvent(this, order);
    publisher.publishEvent(event);
  }
}
