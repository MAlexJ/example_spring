package com.malexj.training_course.component_scan.filter_types;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.component_scan.annotation.Animal;
import com.malexj.training_course.component_scan.bean.simple_pojo.Elephant;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Spring @ComponentScan – Filter Types
 *
 * <p>https://www.baeldung.com/spring-componentscan-filter-type
 *
 * <p>By default, classes annotated with @Component, @Repository, @Service, @Controller are
 * registered as Spring beans. The same goes for classes annotated with a custom annotation that is
 * annotated with @Component.
 *
 * <p>We can extend this behavior by using includeFilters and excludeFilters parameters of
 * the @ComponentScan annotation.
 *
 * <p>There are five types of filters available for ComponentScan.Filter :
 * <li>ANNOTATION
 * <li>ASSIGNABLE_TYPE
 * <li>ASPECTJ
 * <li>REGEX
 * <li>CUSTOM
 */
@ComponentScan(
    basePackages = "com.malexj.training_course.component_scan.bean",
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Animal.class))
public class AnnotationFilterTypeApp extends AbstractClass {

  /**
   * FilterType.ANNOTATION
   *
   * <p>Filter type includes or excludes classes in the component scans which are marked with given
   * annotations
   */
  @Test
  public void filterType() {
    var ctx = new AnnotationConfigApplicationContext(AnnotationFilterTypeApp.class);
    printNewLine(ctx.getBeanDefinitionNames());

    /*
    Note: class Elephant is simple pojo class, it not a bean
     */
    assertTrue(ctx.containsBean("elephant"));
    assertNotNull(ctx.getBean(Elephant.class));

    /*
    Note: @Component Shop class
    */
    assertTrue(ctx.containsBean("shop"));
  }
}
