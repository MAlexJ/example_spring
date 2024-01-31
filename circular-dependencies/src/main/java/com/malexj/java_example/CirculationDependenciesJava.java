package com.malexj.java_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.base.AbstractClass;
import org.junit.jupiter.api.Test;

/**
 * Does Java allow cyclic dependency?
 *
 * DCL60-J. Avoid cyclic dependencies between packages
 */
public class CirculationDependenciesJava extends AbstractClass {

  @Test
  public void runExample() {
    int number = First.beta;
    println(number);
    assertEquals(First.alpha, First.beta);
  }

  public class First {
    public static final int alpha = 5;
    public static final int beta = Second.gamma;
  }

  public class Second {
    public static final int gamma = First.alpha;
  }
}
