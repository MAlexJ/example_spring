package com.malexj.training_course.component_scan.base_scanning.bean_sub_packages;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Component Scan Without Arguments <br>
 * Link: https://www.baeldung.com/spring-component-scanning#component-scan-default
 *
 * <p>@ComponentScan Without arguments tells Spring to scan the current package and all of its
 * sub-packages.
 */
@Component
@ComponentScan
public class ComponentScanWithoutArgumentsApp extends AbstractClass {

  public void run() {
    var ctx = new AnnotationConfigApplicationContext(ComponentScanWithoutArgumentsApp.class);
    printNewLine(ctx.getBeanDefinitionNames());

    /*
    scan the current package and all of its sub-packages
     */
    assertTrue(ctx.containsBean("cat"));
    assertTrue(ctx.containsBean("dog"));
    assertTrue(ctx.containsBean("componentScanWithoutArgumentsApp"));

    /*
    Class com.malexj.training_course.component_scan.bean.Shop located in package above current package
     */
    assertFalse(ctx.containsBean("shop"));
  }
}
