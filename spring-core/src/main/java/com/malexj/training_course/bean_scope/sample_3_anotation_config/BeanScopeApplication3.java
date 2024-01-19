package com.malexj.training_course.bean_scope.sample_3_anotation_config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.bean_scope.sample_3_anotation_config.bean.RobotFactorySingleton;
import com.malexj.training_course.bean_scope.sample_3_anotation_config.bean.RobotPrototype;
import com.malexj.training_course.bean_scope.sample_3_anotation_config.bean.RobotSingleton;
import com.malexj.training_course.bean_scope.sample_3_anotation_config.config.AppConfig3;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Documentation: <a
 * href="https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html">Bean
 * Scope</a>
 */
public class BeanScopeApplication3 extends AbstractClass {

  @Test
  public void test() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);
    RobotFactorySingleton factorySingleton = ctx.getBean(RobotFactorySingleton.class);
    RobotFactorySingleton factorySingleton2 = ctx.getBean(RobotFactorySingleton.class);
    println(factorySingleton);
    println(factorySingleton2, "\n");

    // 1. singleton
    RobotSingleton rs1 = ctx.getBean(RobotSingleton.class);
    println("first singleton =", rs1);
    RobotSingleton rs2 = ctx.getBean(RobotSingleton.class);
    println("second singleton =", rs2, "\n");
    assertEquals(rs1, rs2);

    // 2. prototype
    RobotPrototype r1 = ctx.getBean(RobotPrototype.class);
    println("first prototype =", r1);

    RobotPrototype r2 = ctx.getBean(RobotPrototype.class);
    println("second prototype =", r2);

    RobotPrototype r3 = ctx.getBean(RobotPrototype.class);
    println("third prototype =", r3);

    assertNotEquals(r1, r2);
    assertNotEquals(r2, r3);
  }
}
