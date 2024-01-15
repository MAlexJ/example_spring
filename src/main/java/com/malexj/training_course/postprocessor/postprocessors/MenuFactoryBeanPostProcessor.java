package com.malexj.training_course.postprocessor.postprocessors;

import com.malexj.training_course.postprocessor.bean.Food;
import java.time.LocalTime;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class MenuFactoryBeanPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    // 1. register singleton bean - openTime
    beanFactory.registerSingleton("openTime", LocalTime.of(10, 30));

    addBean("Meat", "Steak", (DefaultListableBeanFactory) beanFactory);
    addBean("Pasta", "Cool pasta", (DefaultListableBeanFactory) beanFactory);
  }

  private void addBean(String type, String dishName, DefaultListableBeanFactory beanFactory) {
    var beanDefinition = new GenericBeanDefinition();
    beanDefinition.setBeanClass(Food.class);
    var constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
    constructorArgumentValues.addIndexedArgumentValue(0, type);
    constructorArgumentValues.addIndexedArgumentValue(1, dishName);

    beanFactory.registerBeanDefinition(dishName.toLowerCase(), beanDefinition);
  }
}
