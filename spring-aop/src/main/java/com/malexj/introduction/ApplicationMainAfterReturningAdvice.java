package com.malexj.introduction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.aop.afterReturning.AfterReturningAspect;
import com.malexj.introduction.bean.Cat;
import com.malexj.introduction.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * After returning advice: <br>
 * <br>
 * Executed after the target method completes successfully (returns without throwing an exception).
 * <br>
 * Used for actions that need to be taken on successful completion of the method. <br>
 * <br>
 * Link to tutorial: <a *
 * href="https://www.youtube.com/watch?v=nQffFaKvGQc&list=PLqj7-hRTFl_p-t5F2zSUlG6_9UIoE2r70">Full *
 * Spring courses</a>
 */
public class ApplicationMainAfterReturningAdvice extends AbstractClass {

  @Test
  public void testAfterReturningAdvice() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    // when
    var cat = ctx.getBean(Cat.class);
    Cat.Sound may = cat.sayMay();
    // and
    println(may);

    // then
    assertEquals("may!", may.toString());
  }

  /**
   * Change returning type in Aspect - {@link
   * AfterReturningAspect#barkAfterReturningAdvice(Cat.Sound)}
   */
  @Test
  public void testAfterReturningAdviceChangeReturningValue() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    // when
    var cat = ctx.getBean(Cat.class);
    Cat.Sound bark = cat.bark();

    // and
    println(bark);

    // then
    assertEquals("No no no", bark.toString());
  }
}
