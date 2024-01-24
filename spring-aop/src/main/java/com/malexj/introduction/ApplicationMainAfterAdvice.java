package com.malexj.introduction;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.bean.University;
import com.malexj.introduction.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * After (finally) advice:
 *
 * <p>1. Executed after the target method, regardless of whether it completes successfully or throws
 * an exception.
 *
 * <p>2. Used for cleanup tasks.
 *
 * <p>Link to tutorial: <a *
 * href="https://www.youtube.com/watch?v=nQffFaKvGQc&list=PLqj7-hRTFl_p-t5F2zSUlG6_9UIoE2r70">Full *
 * Spring courses</a>
 */
public class ApplicationMainAfterAdvice extends AbstractClass {

  @Test
  public void testAfterMethodAdvice() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    // when
    var university = ctx.getBean(University.class);
    println(university);

    // then
    assertTrue(university.getStudents().contains("Alex"));
  }

  @Test
  public void testAfterMethodAdviceWithException() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    // when
    var university = ctx.getBean(University.class);
    println(university);

    // then
    try {
      university.getStudentsWithException();
      fail();
    } catch (Exception e) {
      println("catch exception");
    }
  }
}
