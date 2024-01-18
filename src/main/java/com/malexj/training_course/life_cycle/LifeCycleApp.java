package com.malexj.training_course.life_cycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.training_course.life_cycle.bean.Note;
import com.malexj.training_course.life_cycle.bean.Phone;
import com.malexj.training_course.life_cycle.bean.Shop;
import com.malexj.training_course.life_cycle.configuration.LifeCycleConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleApp {

  /**
   * Bean configuration: <br>
   * 1. @Component annotation <br>
   * 2. @PostConstruct annotation <br>
   * 3. @PreDestroy annotation
   */
  @Test
  public void testPostConstructAndPreDestroyAnnotation() {
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
    var note = ctx.getBean(Note.class);
    assertEquals("note", note.info("note"));
    ctx.close();
  }

  /**
   * Bean configuration: <br>
   * 1. @Bean(initMethod = "init", destroyMethod = "destroy") annotation with init and destroy
   */
  @Test
  public void testBeanConfigurationInitAndDestroyAnnotation() {
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
    var phone = ctx.getBean(Phone.class);
    assertEquals("Nokia", phone.info("Nokia"));
    ctx.close();
  }

  /**
   * Bean configuration: <br>
   * 1. @Bean annotation<br>
   * 2. InitializingBean interface <br>
   * 3. DisposableBean interface
   */
  @Test
  public void testBeanWithInitializingBeaDisposableBeanInterfaces() {
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
    var shop = ctx.getBean(Shop.class);
    assertEquals("Laptop", shop.info("Nokia"));
    ctx.close();
  }
}
