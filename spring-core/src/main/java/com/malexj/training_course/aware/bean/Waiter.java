package com.malexj.training_course.aware.bean;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Waiter extends AbstractClass implements ApplicationContextAware {

  public static final String WAITER_MSG = "Waiter take order";

  private ApplicationContext applicationContext;

  public String takeOrder(String dish) {
    println(WAITER_MSG);
    Chef chef = applicationContext.getBean(Chef.class);
    return WAITER_MSG + ", " + chef.cook(dish);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
