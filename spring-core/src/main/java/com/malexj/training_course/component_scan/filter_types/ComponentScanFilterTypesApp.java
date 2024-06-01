package com.malexj.training_course.component_scan.filter_types;

import com.malexj.training_course.base.AbstractClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
public class ComponentScanFilterTypesApp extends AbstractClass {

  @Test
  public void filterTypes() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext();
  }
}
