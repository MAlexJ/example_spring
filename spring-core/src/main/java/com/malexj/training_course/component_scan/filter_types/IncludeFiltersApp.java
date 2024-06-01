package com.malexj.training_course.component_scan.filter_types;

import com.malexj.training_course.base.AbstractClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IncludeFiltersApp extends AbstractClass {

  @Test
  public void includeFilters() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext();
  }
}
