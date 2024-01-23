package com.malexj.introduction;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.bean.Shop;
import com.malexj.introduction.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Link to tutorial: <a
 * href="https://www.youtube.com/watch?v=nQffFaKvGQc&list=PLqj7-hRTFl_p-t5F2zSUlG6_9UIoE2r70">Full
 * Spring courses</a>
 */
public class ApplicationMain extends AbstractClass {

  @Test
  public void testBeforePointcut() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var user = ctx.getBean("shop", Shop.class);
    String info = user.info("Info");
    println(info);
  }
}
