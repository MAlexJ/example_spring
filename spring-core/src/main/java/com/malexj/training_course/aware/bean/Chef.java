package com.malexj.training_course.aware.bean;

import com.malexj.training_course.base.AbstractClass;
import lombok.Getter;
import org.springframework.beans.factory.BeanNameAware;

public class Chef extends AbstractClass implements BeanNameAware {

  @Getter private String beanName;

  public static final String CHEF_MSG = "Cooking - %s";

  public String cook(String dish) {
    String msg = String.format(CHEF_MSG, dish);
    println(msg);
    return msg;
  }

  @Override
  public void setBeanName(String name) {
    this.beanName = name;
  }
}
