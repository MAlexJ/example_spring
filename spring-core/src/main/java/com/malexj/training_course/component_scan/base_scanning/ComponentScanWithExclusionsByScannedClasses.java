package com.malexj.training_course.component_scan.base_scanning;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.component_scan.base_scanning.bean_sub_packages.ComponentScanWithoutArgumentsApp;
import com.malexj.training_course.component_scan.bean.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * Component Scan with Exclusions <br>
 * Link: https://www.baeldung.com/spring-component-scanning#component-scan-exclusions
 */
@Component
@ComponentScan(
    basePackages = {
      "com.malexj.training_course.component_scan",
      "com.malexj.training_course.bean_scope.sample_1.bean"
    },
    excludeFilters = {
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          value = ComponentScanWithMultiplePackages.class),
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          value = ComponentScanForSpecificPackages.class),
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          value = ComponentScanWithoutArgumentsApp.class),
      @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Shop.class)
    })
public class ComponentScanWithExclusionsByScannedClasses extends AbstractClass {

  //  /** Another way is to use a filter, specifying the pattern for the classes to exclude */
  //  @Test
  //  public void applyFilterSpecifyingByPattern() {}

  /** the annotation supports several flexible options for filtering the scanned classes */
  @Test
  public void applyFilterByScannedClasses() {
    var ctx =
        new AnnotationConfigApplicationContext(ComponentScanWithExclusionsByScannedClasses.class);
    printWewLine(ctx.getBeanDefinitionNames());

    /*
    scan the current package and all of its sub-packages
     */
    assertTrue(ctx.containsBean("cat"));
    assertTrue(ctx.containsBean("dog"));

    /*
    Classes located in different packages
     */
    assertFalse(ctx.containsBean("shop"));
    assertFalse(ctx.containsBean("componentScanWithMultiplePackages"));
    assertFalse(ctx.containsBean("componentScanForSpecificPackages"));
    assertFalse(ctx.containsBean("componentScanWithoutArgumentsApp"));
  }
}
