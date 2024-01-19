package com.malexj.training_course.event_listener.custom;

import com.malexj.training_course.event_listener.custom.bean.Restaurant;
import com.malexj.training_course.event_listener.custom.config.EventCustomConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventCustomApp {
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EventCustomConfig.class);
        var restaurant = ctx.getBean(Restaurant.class);
        restaurant.placeOrder("Milk");
        restaurant.placeOrder("Salad");
        restaurant.placeOrder("Tea");
    }
}
