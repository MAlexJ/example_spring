package com.malexj.spring_solution.use_postconstruct;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.malexj.base.AbstractClass;
import com.malexj.spring_solution.use_postconstruct.bean.BeanWithPostConstruct;
import com.malexj.base.properties.PropsPropertySourcesConfiguration;
import com.malexj.spring_solution.use_postconstruct.bean.SimpleBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Use @PostConstruct
 *
 * <p>Another way to break the cycle is by injecting a dependency using @Autowired on one of the
 * beans and then using a method annotated with @PostConstruct to set the other dependency.
 */
public class PostConstructApp extends AbstractClass {

  @Test
  public void runApp() {
    // get context
    var ctx =
        new AnnotationConfigApplicationContext(
            BeanWithPostConstruct.class, SimpleBean.class, PropsPropertySourcesConfiguration.class);

    // find bean with post construct
    var beanWithPostConstruct = ctx.getBean(BeanWithPostConstruct.class);
    assertNotNull(beanWithPostConstruct);
    println(beanWithPostConstruct);

    // find simple bean
    var simpleBean = ctx.getBean(SimpleBean.class);
    assertNotNull(simpleBean);
    println(simpleBean);
  }
}
