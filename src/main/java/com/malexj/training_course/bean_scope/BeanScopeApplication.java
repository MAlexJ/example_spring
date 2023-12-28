package com.malexj.training_course.bean_scope;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.malexj.training_course.bean_scope.bean.HeadChef;
import com.malexj.training_course.bean_scope.config.RestaurantConfig;
import com.malexj.training_course.utils.UtilsClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeApplication {

  @Test
  public void simpleSingletonScopeTest() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(RestaurantConfig.class);

    // 1. create singleton bean
    HeadChef first = ctx.getBean(HeadChef.class);

    // 2. create singleton bean
    HeadChef second = ctx.getBean(HeadChef.class);

    // 3. make changes in second singleton bead
    second.setName("max");

    // 4. tests
    UtilsClass.println("first:", first, "second:", second);
    assertSame(first, second);
    assertEquals(first, second);
    assertEquals(first.getName(), second.getName());
  }
}
