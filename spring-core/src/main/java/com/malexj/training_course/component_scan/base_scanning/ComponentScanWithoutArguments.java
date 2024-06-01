package com.malexj.training_course.component_scan.base_scanning;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.component_scan.base_scanning.bean_sub_packages.ComponentScanWithoutArgumentsApp;
import org.junit.jupiter.api.Test;

/**
 * Component Scan Without Arguments <br>
 * Link: https://www.baeldung.com/spring-component-scanning#component-scan-default
 *
 * <p>@ComponentScan Without arguments tells Spring to scan the current package and all of its
 * sub-packages.
 */
public class ComponentScanWithoutArguments extends AbstractClass {

  @Test
  public void run() {
    // A class that has two beans within the specified package
    var componentScanWithoutArgumentsApp = new ComponentScanWithoutArgumentsApp();
    componentScanWithoutArgumentsApp.run();
  }
}
