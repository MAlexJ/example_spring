package com.malexj.training_course.life_cycle.bean;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Shop extends AbstractClass implements InitializingBean, DisposableBean, BeanNameAware {

  private String beanNAme;

  @Override
  public void setBeanName(String name) {
    this.beanNAme = name;
    println("0. BeanNameAware::setBeanName", name);
  }

  @Override
  public void afterPropertiesSet() {
    println("1. InitializingBean::afterPropertiesSet ,bean: ", beanNAme);
  }

  public String info(String order) {
    println("2. Shop::info ", order, ", bean: ", beanNAme);
    return order;
  }

  @Override
  public void destroy() {
    println("3. DisposableBean::destroy ,bean: ", beanNAme);
  }
}
