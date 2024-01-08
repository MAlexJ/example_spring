package com.malexj.training_course.proxy.process;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.proxy.bean.IWaiter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Semaphore;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ConcurrentCallsLimiterBeanPostProcessor extends AbstractClass
    implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (bean instanceof IWaiter iWaiter) {
      return createJdkDynamicProxy(bean, iWaiter, beanClass);
    }
    return bean;
  }

  private Object createJdkDynamicProxy(Object bean, IWaiter iWaiter, Class<?> beanClass) {
    return Proxy.newProxyInstance(
        beanClass.getClassLoader(),
        beanClass.getInterfaces(),
        new InvocationHandler() {
          private final Semaphore semaphore = new Semaphore(1);

          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
              println("1. Acquire, availablePermits = " + semaphore.availablePermits());
              semaphore.acquire();
              println("2. Acquire..." + semaphore.availablePermits());
              return method.invoke(bean, args);
            } finally {
              semaphore.release();
              println(
                  "3. semaphore > release > "
                      + iWaiter.name()
                      + ", availablePermits = "
                      + semaphore.availablePermits());
            }
          }
        });
  }
}
