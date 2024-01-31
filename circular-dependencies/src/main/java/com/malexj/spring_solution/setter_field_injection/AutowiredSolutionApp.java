package com.malexj.spring_solution.setter_field_injection;

import com.malexj.base.AbstractClass;
import com.malexj.spring_solution.setter_field_injection.bean.Child;
import com.malexj.spring_solution.setter_field_injection.bean.Parent;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * NOTE: NPE!!!! <br>
 * possibility of incomplete object construction
 *
 * <p>Tutorial: https://www.youtube.com/watch?v=lfX0ULn6b-U
 *
 * <p>Investigate in IDE: <br>
 * Select project package > Analyze > Analyze Dependency Matrix...
 */
public class AutowiredSolutionApp extends AbstractClass {

  @Test
  public void runApp() {
    var context = new AnnotationConfigApplicationContext(Child.class, Parent.class);
    var child = context.getBean(Child.class);
    var parent = context.getBean(Parent.class);
    println("1.", "child:", child);
    println("2.", "parent:", parent);
  }
}
