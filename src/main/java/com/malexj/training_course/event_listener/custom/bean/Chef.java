package com.malexj.training_course.event_listener.custom.bean;

import com.malexj.training_course.base.AbstractClass;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chef extends AbstractClass {

  private final BlockingQueue<String> queue;

  //  @PostConstruct inside @Bean
  public void init() {
    new Thread(this::processOrder).start();
  }

  public void processOrder() {
    long currentTime = System.currentTimeMillis();
    try {
      while (System.currentTimeMillis() - currentTime < 10000) {
        if (!queue.isEmpty()) {
          println("  >>> Chef is preparing: " + queue.take());
          TimeUnit.SECONDS.sleep(3);
        }
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
