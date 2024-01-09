package com.malexj.training_course.event_listener.custom.scheduler;

import com.malexj.training_course.base.AbstractClass;
import java.util.concurrent.BlockingQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChefScheduler extends AbstractClass {

  private final BlockingQueue<String> queue;

  @Scheduled(fixedRate = 4000)
  public void processOrder() {
    if (queue.isEmpty()) {
      System.exit(0);
      return;
    }

    try {
      println("  >>> Chef is preparing: " + queue.take());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
