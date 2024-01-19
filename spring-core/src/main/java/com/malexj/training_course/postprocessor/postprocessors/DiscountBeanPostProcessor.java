package com.malexj.training_course.postprocessor.postprocessors;

import com.malexj.training_course.postprocessor.annotation.Discount;
import com.malexj.training_course.postprocessor.bean.Food;
import java.lang.reflect.Field;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DiscountBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof Food food) {
      Class<?> foodClass = bean.getClass();
      try {
        Field discountField = foodClass.getDeclaredField("percent");
        if (discountField.isAnnotationPresent(Discount.class)) {
          if (food.getDishName().equalsIgnoreCase("Steak")) {
            food.setPercent(10);
            return bean;
          }
          Discount discount = discountField.getAnnotation(Discount.class);
          food.setPercent(discount.percent());
        }
      } catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
      }
    }
    return bean;
  }
}
