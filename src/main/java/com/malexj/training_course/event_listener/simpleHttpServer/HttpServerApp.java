package com.malexj.training_course.event_listener.simpleHttpServer;

import com.malexj.training_course.event_listener.simpleHttpServer.config.HttpServerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HttpServerApp {
  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(HttpServerConfig.class);
    var httpServer = ctx.getBean(BasicHttpServer.class);
  }
}
