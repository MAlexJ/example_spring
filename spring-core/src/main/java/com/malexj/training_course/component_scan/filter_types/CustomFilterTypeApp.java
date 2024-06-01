package com.malexj.training_course.component_scan.filter_types;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.component_scan.bean.simple_pojo.Elephant;
import com.malexj.training_course.component_scan.bean.simple_pojo.impl.BmvIService;
import com.malexj.training_course.component_scan.filter_types.filter_configuration.ComponentScanCustomFilter;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * FilterType.CUSTOM
 *
 * <p>link: https://www.baeldung.com/spring-componentscan-filter-type#custom_filter
 */
@ComponentScan(
    basePackages = "com.malexj.training_course.component_scan.bean.simple_pojo",
    includeFilters =
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = ComponentScanCustomFilter.class))
public class CustomFilterTypeApp extends AbstractClass {

  /**
   * FilterType.CUSTOM
   *
   * <p>If none of the above filter types meet our requirement then we can also create a custom
   * filter type.
   */
  @Test
  public void filterType() {
    var context = new AnnotationConfigApplicationContext(CustomFilterTypeApp.class);
    printNewLine(context.getBeanDefinitionNames());

    /*
    Note: class Elephant is simple pojo class, it not a bean
     */
    assertTrue(context.containsBean("elephant"));
    assertNotNull(context.getBean(Elephant.class));

    /*
    Note: class Elephant is simple pojo class, it not a bean
     */
    assertTrue(context.containsBean("bmvIService"));
    assertNotNull(context.getBean(BmvIService.class));
  }
}
