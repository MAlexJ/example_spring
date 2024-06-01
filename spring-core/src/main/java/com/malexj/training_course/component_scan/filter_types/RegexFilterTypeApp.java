package com.malexj.training_course.component_scan.filter_types;

import static org.junit.jupiter.api.Assertions.*;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.component_scan.bean.simple_pojo.Elephant;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * FilterType.REGEX
 *
 * <p>link: https://www.baeldung.com/spring-componentscan-filter-type#regex_filter
 */
@ComponentScan(
    basePackages = "com.malexj.training_course.component_scan.bean",
    includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*[nt]"),
    excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*[op]"))
public class RegexFilterTypeApp extends AbstractClass {

  /**
   * The REGEX Filter type
   *
   * <p>Filter checks if class name matching given regex pattern. <br>
   * FilterType.REGEX checks both simple and fully-qualified class names.
   */
  @Test
  public void filterType() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(RegexFilterTypeApp.class);
    printNewLine(ctx.getBeanDefinitionNames());

    /*
    Note: class Elephant is simple pojo class, it not a bean
     */
    assertTrue(ctx.containsBean("elephant"));
    assertNotNull(ctx.getBean(Elephant.class));

    /*
    Note: @Component Shop class
    */
    assertFalse(ctx.containsBean("shop"));
  }
}
