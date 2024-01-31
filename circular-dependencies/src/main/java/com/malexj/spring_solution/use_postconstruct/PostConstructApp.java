package com.malexj.spring_solution.use_postconstruct;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.malexj.spring_solution.use_postconstruct.bean.BeanA;
import com.malexj.spring_solution.use_postconstruct.bean.BeanB;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Use @PostConstruct
 *
 * <p>Another way to break the cycle is by injecting a dependency using @Autowired on one of the
 * beans and then using a method annotated with @PostConstruct to set the other dependency.
 */
public class PostConstructApp {

  @Test
  public void runApp() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanA.class, BeanB.class);
    assertNotNull(ctx.getBean(BeanA.class));
    assertNotNull(ctx.getBean(BeanB.class));
  }
}
