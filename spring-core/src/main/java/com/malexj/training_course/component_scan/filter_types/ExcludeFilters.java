package com.malexj.training_course.component_scan.filter_types;

import com.malexj.training_course.base.AbstractClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExcludeFilters extends AbstractClass {

  @Test
  public void excludeFilters() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext();
  }
}
