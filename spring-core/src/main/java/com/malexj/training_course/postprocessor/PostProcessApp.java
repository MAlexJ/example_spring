package com.malexj.training_course.postprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.postprocessor.bean.Food;
import com.malexj.training_course.postprocessor.bean.Restaurant;
import com.malexj.training_course.postprocessor.bean.Waiter;
import com.malexj.training_course.postprocessor.config.PostProcessConfiguration;
import com.malexj.training_course.postprocessor.postprocessors.WaiterOnDutyBeanFactoryPostProcessor;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * PostProcessors: <br>
 * 1. Spring Container:<br>
 * 1.1. BeanFactoryPostProcessor <br>
 * 1.2. BeanDefinitionRegistryPostProcessor <br>
 * 2. Beans <br>
 * 2.1. BeanPostProcessor <br>
 * 2.2. InitiationAwareBeanPostProcessor
 */
public class PostProcessApp extends AbstractClass {

  /**
   * 1. Setup Bean
   *
   * <p>BeanPostProcessor.class <br>
   * Modify bean behaviors, set up new field value
   */
  @Test
  public void testDiscountBeanPostProcessor() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(PostProcessConfiguration.class);
    var restaurant = ctx.getBean(Restaurant.class);

    int discount =
        restaurant.getMenu().stream()
            .filter(isFoodName("Steak"))
            .peek(this::println)
            .map(Food::discount)
            .findFirst()
            .orElseThrow();

    assertEquals(10, discount);

    discount =
        restaurant.getMenu().stream()
            .filter(isFoodName("Cool pasta"))
            .peek(this::println)
            .map(Food::discount)
            .findFirst()
            .orElseThrow();

    assertEquals(30, discount);
  }

  private Predicate<Food> isFoodName(String dishAme) {
    return food -> food.getDishName().equals(dishAme);
  }

  /**
   * 1. Setup Spring container
   *
   * <p>BeanFactoryPostProcessor.class <br>
   * Register beans inside BeanFactoryPostProcessor
   */
  @Test
  public void testMenuFactoryBeanPostProcessor() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(PostProcessConfiguration.class);
    var restaurant = ctx.getBean(Restaurant.class);

    // when
    List<String> types = restaurant.getInfo();

    // then
    assertTrue(types.contains("Meat"));
    assertTrue(types.contains("Pasta"));
    assertEquals(types.size(), 2);
  }

  /**
   * 1. Setup Spring container
   *
   * <p>BeanFactoryPostProcessor.class
   *
   * <p>Use BeanFactoryPostProcessor to change 'Waiter.class' bean behaviors {@link
   * WaiterOnDutyBeanFactoryPostProcessor#postProcessBeanFactory}
   *
   * <p>class field 'onDuty' was changed to 'true' in BeanFactoryPostProcessor (container
   * initialization)
   */
  @Test
  public void testWaiterOnDutyBeanFactoryPostProcessor() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(PostProcessConfiguration.class);
    Waiter waiter = ctx.getBean(Waiter.class);

    // when
    String answer = waiter.takeOrder();

    // then
    assertEquals("I can take order", answer);
  }
}
