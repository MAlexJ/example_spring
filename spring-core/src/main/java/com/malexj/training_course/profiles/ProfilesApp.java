package com.malexj.training_course.profiles;

import static org.junit.jupiter.api.Assertions.*;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.profiles.bean.NotDevDatasourceConfig;
import com.malexj.training_course.profiles.config.ComponentScanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring Profiles
 *
 * <p>https://www.baeldung.com/spring-profiles
 *
 * <p>Profiles are a core feature of the framework — allowing us to map our beans to different
 * profiles — for example, dev, test, and prod.
 *
 * <p>We can then activate different profiles in different environments to bootstrap only the beans
 * we need.
 */
public class ProfilesApp extends AbstractClass {

  @Test
  public void testNotDevProfile() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    println(ctx.getBeanDefinitionNames());

    // bean under 'dev' profile
    assertFalse(ctx.containsBean("devDatasourceConfig"));

    // without profile
    assertTrue(ctx.containsBean("myBean"));

    NotDevDatasourceConfig notDevDatasource = ctx.getBean(NotDevDatasourceConfig.class);
    assertNotNull(notDevDatasource);
  }
}
