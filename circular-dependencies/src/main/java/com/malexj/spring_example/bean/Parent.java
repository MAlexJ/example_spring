package com.malexj.spring_example.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Parent {

    @Value("parent")
    private String name;

    private final Child child;
}
