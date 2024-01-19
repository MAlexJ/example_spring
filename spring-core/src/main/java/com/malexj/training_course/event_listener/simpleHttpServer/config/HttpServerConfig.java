package com.malexj.training_course.event_listener.simpleHttpServer.config;

import com.malexj.training_course.event_listener.simpleHttpServer.BasicHttpServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.malexj.training_course.event_listener.simpleHttpServer")
public class HttpServerConfig {

    @Bean(initMethod = "startServer")
    public BasicHttpServer basicHttpServer(){
        return new BasicHttpServer();
    }
}
