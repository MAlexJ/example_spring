package com.malexj.training_course.component_scan.filter_types;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.component_scan.bean.simple_pojo.MyIService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * ASSIGNABLE_TYPE
 *
 * <p>link: https://www.baeldung.com/spring-componentscan-filter-type#filtertypeassignabletype
 */
@Configuration
@ComponentScan(
    basePackages = "com.malexj.training_course.component_scan.bean.simple_pojo",
    includeFilters = {
      @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyIService.class)
    },
    excludeFilters = {
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          classes = AnnotationFilterTypeApp.class)
    })
public class AssignableFilterTypeApp extends AbstractClass {

  /**
   * The ASSIGNABLE_TYPE
   *
   * <p>Filters all classes during the component scan that either extend the class or implement the
   * interface of the specified type.
   */
  @Test
  public void filterType() {
    var ctx = new AnnotationConfigApplicationContext(AssignableFilterTypeApp.class);
    printNewLine(ctx.getBeanDefinitionNames());

    assertTrue(ctx.containsBean("audiIService"));
    assertTrue(ctx.containsBean("bmvIService"));
  }
}
