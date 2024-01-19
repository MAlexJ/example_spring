package com.malexj.training_course.aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class Customer implements BeanFactoryAware {

  private BeanFactory beanFactory;

  public String askChef(String dish){
    var chef = beanFactory.getBean(Chef.class);
    return chef.cook(dish);
  }


  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }
}
