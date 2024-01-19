package com.malexj.training_course.life_cycle.bean;

import com.malexj.training_course.base.AbstractClass;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class Note extends AbstractClass implements BeanNameAware {

  private String beanName;

  @PostConstruct
  public void init() {
    println("1. init method, bean:", beanName);
  }

  public String info(String note) {
    println("2.", note);
    return note;
  }

  @PreDestroy
  public void destroy() {
    println("3. destroy method, bean:", beanName);
  }

  @Override
  public void setBeanName(String name) {
    this.beanName = name;
  }
}
