package com.malexj.training_course.event_listener.custom.config;

import com.malexj.training_course.event_listener.custom.bean.Chef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
@ComponentScan("com.malexj.training_course.event_listener.custom")
public class EventCustomConfig {

    @Bean
    public BlockingQueue<String> blockingQueue(){
        return new LinkedBlockingQueue<>();
    }


    @Bean(initMethod = "init")
    public Chef chef(BlockingQueue<String> queue){
        return new Chef(queue);
    }
}
