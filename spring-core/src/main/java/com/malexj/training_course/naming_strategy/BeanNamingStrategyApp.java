package com.malexj.training_course.naming_strategy;

import static org.junit.jupiter.api.Assertions.*;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.naming_strategy.bean.BeanWithValue;
import com.malexj.training_course.naming_strategy.bean.CustomNamingBean;
import com.malexj.training_course.naming_strategy.config.ComponentScanConfig;
import com.malexj.training_course.naming_strategy.qualifier.Cat;
import com.malexj.training_course.naming_strategy.qualifier.Dog;
import com.malexj.training_course.naming_strategy.service.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring Bean Names
 *
 * <p>https://www.baeldung.com/spring-bean-names
 */
public class BeanNamingStrategyApp extends AbstractClass {

  /**
   * Class-Level Annotations
   *
   * <p>Spring uses the class name and converts the first letter to lowercase.
   */
  @Test
  public void classLevelAnnotations() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
      println(beanDefinitionName);
    }
    assertTrue(ctx.containsBean("classLevelAnnotationsBean"));
  }

  /**
   * Method-Level Annotation
   *
   * <p>When we use the @Bean annotation on a method, Spring uses the method name as a bean name.
   */
  @Test
  public void methodLevelAnnotations() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    assertTrue(ctx.containsBean("auditBean"));
  }

  /**
   * Custom Naming of Beans
   *
   * <p>Similar to @Component(“myBean”), we can specify the name using other annotations such
   * as @Service(“myService”), @Controller(“myController”), and @Bean(“myCustomBean”), and then
   * Spring will register that bean with the given name.
   */
  @Test
  public void customNamingOfBeans() {
    var ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    assertTrue(ctx.containsBean("customBean"));
    var customNamingBean = ctx.getBean(CustomNamingBean.class);
    assertNotNull(customNamingBean);
  }

  /**
   * Bean With Value
   *
   * <p>This default bean name can be overwritten — we can specify the value using the @Bean
   * annotation
   */
  @Test
  public void beanWithValue() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    assertTrue(ctx.containsBean("myBean"));

    var beanWithValue = ctx.getBean(BeanWithValue.class);
    assertNotNull(beanWithValue);

    assertEquals(beanWithValue, ctx.getBean("myBean"));
  }

  /**
   * Qualifier With Value
   *
   * <p>Whenever we use this qualified name, Spring will inject the bean with that qualified name
   * into the targeted bean.
   */
  @Test
  public void qualifierWithValue() {
    var ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    var service = ctx.getBean(PetService.class);

    var cat = ctx.getBean(Cat.class);
    var dog = ctx.getBean(Dog.class);
    assertEquals(service.catName(), cat.name());
    assertEquals(service.dogName(), dog.name());
  }
}
