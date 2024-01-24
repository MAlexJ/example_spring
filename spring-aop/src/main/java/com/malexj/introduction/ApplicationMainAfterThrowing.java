package com.malexj.introduction;

import static org.junit.jupiter.api.Assertions.fail;

import com.malexj.introduction.bean.Student;
import com.malexj.introduction.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * After throwing advice: <br>
 * <br>
 * 1. Executed if the target method throws an exception.<br>
 * 2. Useful for handling exceptions or logging errors.
 */
public class ApplicationMainAfterThrowing {

  @Test
  public void testAfterThrowing() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var student = ctx.getBean("student", Student.class);
    try {
      student.printThrowException();
      fail();
    } catch (Exception e) {
      // none
    }
  }
}
