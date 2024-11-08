package com.malexj.training_course.life_cycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.training_course.life_cycle.bean.Note;
import com.malexj.training_course.life_cycle.bean.Phone;
import com.malexj.training_course.life_cycle.bean.Shop;
import com.malexj.training_course.life_cycle.configuration.PhoneLifeCycleConfiguration;
import com.malexj.training_course.life_cycle.configuration.ShopLifeCycleConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleApp {

  /*
   * Bean configuration:
   * 1. Class initialization: constructor
   * 2. BeanNameAware::setBeanName > @Component annotation
   * 3. @PostConstruct annotation
   * 4. @PreDestroy annotation
   */
  @Test
  public void testPostConstructAndPreDestroyAnnotation() {
    // given
    var ctx = new AnnotationConfigApplicationContext(Note.class);

    // when
    var note = ctx.getBean(Note.class);

    // then
    assertEquals("new note name", note.info("new note name"));

    // and
    ctx.close();
  }

  /*
   * Bean configuration:
   * 1. @Bean(initMethod = "init", destroyMethod = "destroy") annotation with init and destroy
   */
  @Test
  public void testBeanConfigurationInitAndDestroyAnnotation() {
    // given
    var ctx = new AnnotationConfigApplicationContext(PhoneLifeCycleConfiguration.class);

    // when
    var phone = ctx.getBean(Phone.class);

    // then
    assertEquals("Nokia", phone.info("Nokia"));

    // and
    ctx.close();
  }

  /*
   * Bean configuration:
   * 1. @Bean annotation
   * 2. InitializingBean interface
   * 3. DisposableBean interface
   */
  @Test
  public void testBeanWithInitializingBeaDisposableBeanInterfaces() {
    // given
    var ctx = new AnnotationConfigApplicationContext(ShopLifeCycleConfiguration.class);

    // when
    var shop = ctx.getBean(Shop.class);

    // then
    assertEquals("Laptop", shop.info("Laptop"));

    // and
    ctx.close();
  }
}
