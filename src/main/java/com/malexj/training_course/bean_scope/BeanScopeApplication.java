package com.malexj.training_course.bean_scope;

import static org.junit.jupiter.api.Assertions.*;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.bean_scope.bean.HeadChef;
import com.malexj.training_course.bean_scope.bean.Waiter;
import com.malexj.training_course.bean_scope.config.RestaurantConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeApplication extends AbstractClass {

  @Test
  public void runAll() {
    testSingletonScope();
    testPrototypeScope();
  }

  @Test
  public void testSingletonScope() {
    println(">>> Test Singleton Scope");
    ApplicationContext ctx = new AnnotationConfigApplicationContext(RestaurantConfig.class);

    // 1. create singleton bean
    HeadChef first = ctx.getBean(HeadChef.class);

    // 2. create singleton bean
    HeadChef second = ctx.getBean(HeadChef.class);

    // 3. make changes in second singleton bead
    second.setName("max");

    // 4. tests
    assertSame(first, second);
    assertEquals(first, second);
    assertEquals(first.getName(), second.getName());
    println(
        "first:",
        first,
        "second:",
        second,
        "\nfirst .hashCode():",
        first.hashCode(),
        "second .hashCode():",
        second.hashCode());
  }

  @Test
  public void testPrototypeScope() {
    println(">>> Test Prototype Scope");
    ApplicationContext ctx = new AnnotationConfigApplicationContext(RestaurantConfig.class);

    Waiter first = ctx.getBean(Waiter.class);
    Waiter second = ctx.getBean(Waiter.class);

    assertNotSame(first, second);

    first.setName("Alex");
    second.setName("Max");

    assertNotEquals(first.getName(), second.getName());
    println(
        "first:",
        first,
        "second:",
        second,
        "\nfirst .hashCode():",
        first.hashCode(),
        "second .hashCode():",
        second.hashCode());
  }
}
