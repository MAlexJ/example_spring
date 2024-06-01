package com.malexj.training_course.component_scan.base_scanning;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * ComponentScan with Multiple Packages <br>
 * Link: https://www.baeldung.com/spring-component-scanning#2-componentscan-with-multiple-packages
 */

/*
Spring provides a convenient way to specify multiple package names.
 1. @ComponentScan(basePackages = {"com.baeldung.componentscan.springapp.animals",
                      "com.baeldung.componentscan.springapp.flowers"})

  Alternatively, since spring 4.1.1, we can use a comma, a semicolon, or a space to separate the packages list:

  2. @ComponentScan(basePackages = "com.baeldung.componentscan.springapp.animals;com.baeldung.componentscan.springapp.flowers")
  @ComponentScan(basePackages = "com.baeldung.componentscan.springapp.animals,com.baeldung.componentscan.springapp.flowers")
  @ComponentScan(basePackages = "com.baeldung.componentscan.springapp.animals com.baeldung.componentscan.springapp.flowers")
       */
@Component
@ComponentScan(
    basePackages = {
      "com.malexj.training_course.component_scan.base_scanning",
      "com.malexj.training_course.bean_scope.sample_1.bean"
    })
public class ComponentScanWithMultiplePackages extends AbstractClass {

  @Test
  public void run() {
    var ctx = new AnnotationConfigApplicationContext(ComponentScanWithMultiplePackages.class);
    printNewLine(ctx.getBeanDefinitionNames());

    /*
    scan the current package and all of its sub-packages
     */
    assertTrue(ctx.containsBean("cat"));
    assertTrue(ctx.containsBean("dog"));
    assertTrue(ctx.containsBean("componentScanWithoutArgumentsApp"));

    /*
    Class com.malexj.training_course.component_scan.bean.Shop located in one level with base package
     */
    assertTrue(ctx.containsBean("shop"));

    /*
    Class Waiter and HeadChef located in different packages
     */
    assertTrue(ctx.containsBean("waiter"));
    assertTrue(ctx.containsBean("headChef"));
  }
}
