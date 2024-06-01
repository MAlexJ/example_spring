package com.malexj.training_course.component_scan.filter_types;

import com.malexj.training_course.base.AbstractClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * FilterType.ASPECTJ
 *
 * <p>link: https://www.baeldung.com/spring-componentscan-filter-type#aspect_filter
 */
public class AspectjFilterTypeApp extends AbstractClass {

  @Test
  public void filterType() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AspectjFilterTypeApp.class);
  }
}
