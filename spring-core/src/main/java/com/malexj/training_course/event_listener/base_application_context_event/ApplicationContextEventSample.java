package com.malexj.training_course.event_listener.base_application_context_event;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.event_listener.base_application_context_event.bean.EventPublisherComponent;
import com.malexj.training_course.event_listener.base_application_context_event.config.EvenListenerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Tutorial: Spring framework Event Listener
 *
 * <p>Link: <a
 * href="https://www.youtube.com/watch?v=osr2Kcp3qSk&list=PLHl4uBTw_rjOXbZQ08Y65ZyhSIQ56GoBt&index=10">Event
 * Listener</a>
 *
 * <p><a href="https://habr.com/ru/articles/720794/">Spring ApplicationContextEvent</a>
 */
public class ApplicationContextEventSample extends AbstractClass {

  /**
   * In the app we have four types of ApplicationContextEvent: <br>
   * 1. ContextRefreshedEvent <br>
   * 2. ContextStartedEvent <br>
   * 3. ContextStoppedEvent <br>
   * 4. ContextClosedEvent <br>
   * <br>
   * additional: <br>
   * 5. PayloadApplicationEvent
   */
  @Test
  public void applicationContextEvent() {
    // 1. run context
    var context = new AnnotationConfigApplicationContext(EvenListenerConfiguration.class);

    // 2. publish event
    var publisherComponent = context.getBean(EventPublisherComponent.class);
    publisherComponent.publishEvent("New order event!");

    // 3. action with app context
    context.start();
    context.stop();
    context.close();
  }
}
