package com.malexj.training_course.life_cycle.bean;

import com.malexj.training_course.base.AbstractClass;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Note extends AbstractClass {

  @PostConstruct
  public void init() {
    println("1. init method");
  }

  public String info(String note) {
    println("2.", note);
    return note;
  }

  @PreDestroy
  public void destroy() {
    println("3. destroy method");
  }
}
