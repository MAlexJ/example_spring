package com.malexj.training_course.event_listener.custom.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {

  @Getter private final String orderDetails;

  public OrderEvent(Object source, String orderDetails) {
    super(source);
    this.orderDetails = orderDetails;
  }
}
