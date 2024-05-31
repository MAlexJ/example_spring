package com.malexj.training_course.life_cycle.bean;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.beans.factory.BeanNameAware;

public class Phone extends AbstractClass implements BeanNameAware {

  private String beanName;

  public void init() {
    println("1. Phone::init method, beanName:", beanName);
  }

  public String info(String phone) {
    println("2. Phone::info:", phone, ", beanName:", beanName);
    return phone;
  }

  public void destroy() {
    println("3. Phone::destroy method, beanName:", beanName);
  }

  @Override
  public void setBeanName(String name) {
    this.beanName = name.toUpperCase();
    println("0. BeanNameAware::setBeanName, beanName", beanName);
  }
}
