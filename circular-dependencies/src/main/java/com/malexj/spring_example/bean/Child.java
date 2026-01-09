package com.malexj.spring_example.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Child {

  @Value("child")
  private String name;

  private final Parent parent;
}
