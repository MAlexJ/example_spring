package com.malexj.training_course.event_listener.custom.listener;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.event_listener.custom.event.OrderEvent;
import java.util.concurrent.BlockingQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderListener extends AbstractClass {

  private final BlockingQueue<String> queue;

  @EventListener(OrderEvent.class)
  public void handleOrderEvent(OrderEvent event) {
    String orderDetails = event.getOrderDetails();
    println(" >>> Event is caught: "+ orderDetails);
    try {
      queue.put(orderDetails);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
