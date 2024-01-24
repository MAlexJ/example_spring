package com.malexj.introduction;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.bean.Shop;
import com.malexj.introduction.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Before advice:
 *
 * <p>1. Executed before the target method.
 *
 * <p>2. Commonly used for logging, security checks, and setup actions.<
 *
 * <p>Link to tutorial: <a
 * href="https://www.youtube.com/watch?v=nQffFaKvGQc&list=PLqj7-hRTFl_p-t5F2zSUlG6_9UIoE2r70">Full
 * Spring courses</a>
 */
public class ApplicationMainBeforeAdvice extends AbstractClass {

  @Test
  public void testBeforePointcut() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var shop = ctx.getBean("shop", Shop.class);
    String info = shop.info("Info");
    println("result:", info);
  }

  @Test
  public void testBeforeAnnotationPointcut() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var shop = ctx.getBean("shop", Shop.class);
    String info = shop.addInfo("Info");
    println("result:", info);
  }
}
