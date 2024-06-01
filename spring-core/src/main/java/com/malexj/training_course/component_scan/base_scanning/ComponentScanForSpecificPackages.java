package com.malexj.training_course.component_scan.base_scanning;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Component for Specific Packages <br>
 * Link: https://www.baeldung.com/spring-component-scanning#component-scan-specific
 */
@Component
@ComponentScan(basePackages = "com.malexj.training_course.component_scan")
public class ComponentScanForSpecificPackages extends AbstractClass {

  @Test
  public void run() {
    var ctx = new AnnotationConfigApplicationContext(ComponentScanForSpecificPackages.class);
    printWewLine(ctx.getBeanDefinitionNames());

    /*
    scan the current package and all of its sub-packages
     */
    assertTrue(ctx.containsBean("cat"));
    assertTrue(ctx.containsBean("dog"));

    /*
    Class com.malexj.training_course.component_scan.bean.Shop located in one level with base package
     */
    assertTrue(ctx.containsBean("shop"));

    /*
    Class located in sub-packege
    */
    assertTrue(ctx.containsBean("componentScanWithoutArgumentsApp"));
  }
}
