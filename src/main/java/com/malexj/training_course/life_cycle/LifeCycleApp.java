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
    // given
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);

    // when
    var note = ctx.getBean(Note.class);

    // then
    assertEquals("note", note.info("note"));

    // and
    ctx.close();
  }

  /**
   * Bean configuration: <br>
   * 1. @Bean(initMethod = "init", destroyMethod = "destroy") annotation with init and destroy
   */
  @Test
  public void testBeanConfigurationInitAndDestroyAnnotation() {
    // given
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);

    // when
    var phone = ctx.getBean(Phone.class);

    // then
    assertEquals("Nokia", phone.info("Nokia"));

    // and
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
    // given
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);

    // when
    var shop = ctx.getBean(Shop.class);

    // then
    assertEquals("Laptop", shop.info("Nokia"));

    // and
    ctx.close();
  }
}
