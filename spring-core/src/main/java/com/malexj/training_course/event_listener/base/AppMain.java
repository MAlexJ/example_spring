package com.malexj.training_course.event_listener.base;

import com.malexj.training_course.event_listener.base.config.EvenListenerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Tutorial: <a
 * href="https://www.youtube.com/watch?v=osr2Kcp3qSk&list=PLHl4uBTw_rjOXbZQ08Y65ZyhSIQ56GoBt&index=10">Spring
 * Framework. Event Listener</a>
 */
public class AppMain {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(EvenListenerConfiguration.class);
    context.start();
    context.stop();
  }
}
