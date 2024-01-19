package com.malexj.training_course.proxy.process;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.proxy.bean.Customer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

@Component
public class PlaceOrderBeanPostProcessor extends AbstractClass implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (bean instanceof Customer customer) {
      return createCglibProxy(beanName, customer, beanClass);
    }
    return bean;
  }

  private Object createCglibProxy(String beanName, Customer customer, Class<?> beanClass) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(beanClass);
    enhancer.setCallback(
        (MethodInterceptor)
            (obj, method, args, proxy) -> {
              println(
                  "  Proxy: Client: '"
                      + customer.getName()
                      + "' place order! , beanName = "
                      + beanName);
              return method.invoke(customer, args);
            });
    return enhancer.create();
  }
}
