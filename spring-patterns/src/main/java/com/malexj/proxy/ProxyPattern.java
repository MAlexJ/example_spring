package com.malexj.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.base.AbstractClass;
import org.junit.jupiter.api.Test;

/*
 * Information <a href="https://www.baeldung.com/java-proxy-pattern">The Proxy Pattern in Java</a>
 * site: www.baeldung.com
 */
public class ProxyPattern extends AbstractClass {

  @Test
  public void run() {
    println("Proxy Pattern in Java");
    ExpensiveObject expensiveObject = new ExpensiveObjectProxy();

    // test 1
    String process = expensiveObject.process();
    assertEquals("Processing complete", process);

    // test 2
    process = expensiveObject.process();
    assertEquals("Processing complete", process);
  }
}
