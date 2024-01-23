package com.malexj;

import com.malexj.base.AbstractClass;
import com.malexj.bean.User;
import com.malexj.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain extends AbstractClass {

  @Test
  public void testBeforePointcut() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var user = ctx.getBean("user", User.class);
    String info = user.info("Info");
    println(info);
  }
}
