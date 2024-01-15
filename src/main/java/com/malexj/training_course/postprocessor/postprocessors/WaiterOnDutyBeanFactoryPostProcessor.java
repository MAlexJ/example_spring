package com.malexj.training_course.postprocessor.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class WaiterOnDutyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  /**
   * Modify the application context's internal bean factory after its standard initialization. All
   * bean definitions will have been loaded, but no beans will have been instantiated yet. This
   * allows for overriding or adding properties even to eager-initializing beans. Params:
   * beanFactory – the bean factory used by the application context
   *
   * @param beanFactory the bean factory used by the application context
   * @throws BeansException - in case of errors
   */
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("waiter");
    MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
    propertyValues.add("onDuty", true);
  }
}
