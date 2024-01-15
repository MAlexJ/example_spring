package com.malexj.training_course.postprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.training_course.postprocessor.bean.Waiter;
import com.malexj.training_course.postprocessor.config.PostProcessConfiguration;
import com.malexj.training_course.postprocessor.postprocessors.WaiterOnDutyBeanFactoryPostProcessor;
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
public class PostProcessApp {

  @Test
  public void test() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(PostProcessConfiguration.class);


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
