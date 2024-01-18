package com.malexj.training_course.life_cycle.bean;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Shop extends AbstractClass implements InitializingBean, DisposableBean, BeanNameAware {

  private String beanNAme;

  public String info(String order) {
    println("2. order: ", beanNAme, ", bean: ", beanNAme);
    return order;
  }

  @Override
  public void afterPropertiesSet() throws Exception {}

  @Override
  public void destroy() throws Exception {}

  @Override
  public void setBeanName(String name) {
    this.beanNAme = name;
  }
}
