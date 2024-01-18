package com.malexj.training_course.life_cycle.bean;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.beans.factory.BeanNameAware;

public class Phone extends AbstractClass implements BeanNameAware {

  private String beanName;

  public void init() {
    println("1. init method, bean:", beanName);
  }

  public String info(String phone) {
    println("2. phone:", phone, ", beanName:", beanName);
    return phone;
  }

  public void destroy() {
    println("3. destroy method, bean:", beanName);
  }

  @Override
  public void setBeanName(String name) {
    this.beanName = name;
  }
}
