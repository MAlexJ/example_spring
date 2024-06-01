package com.malexj.training_course.component_scan.base_scanning;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
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
    excludeFilters = {
      @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Shop"),
      @ComponentScan.Filter(
          type = FilterType.REGEX,
          pattern = ".*ComponentScanWithMultiplePackages"),
      @ComponentScan.Filter(
          type = FilterType.REGEX,
          pattern = ".*ComponentScanForSpecificPackages"),
      @ComponentScan.Filter(
          type = FilterType.REGEX,
          pattern = ".*ComponentScanWithExclusionsByScannedClasses"),
      @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*ComponentScanWithoutArgumentsApp")
    })
public class ComponentScanWithExclusionsByPatternMatching extends AbstractClass {

  /** Another way is to use a filter, specifying the pattern for the classes to exclude */
  @Test
  public void applyFilterSpecifyingByPattern() {
    var ctx =
        new AnnotationConfigApplicationContext(ComponentScanWithExclusionsByPatternMatching.class);

    printNewLine(ctx.getBeanDefinitionNames());

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
    assertFalse(ctx.containsBean("componentScanWithExclusionsByScannedClasses"));
  }
}
