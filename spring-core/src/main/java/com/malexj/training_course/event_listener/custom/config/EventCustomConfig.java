package com.malexj.training_course.event_listener.custom.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
@ComponentScan("com.malexj.training_course.event_listener.custom")
public class EventCustomConfig {

  @Bean
  public BlockingQueue<String> blockingQueue() {
    return new LinkedBlockingQueue<>();
  }

  @Bean
  public TaskScheduler threadPoolTaskScheduler() {
    return new ThreadPoolTaskScheduler();
  }
}
