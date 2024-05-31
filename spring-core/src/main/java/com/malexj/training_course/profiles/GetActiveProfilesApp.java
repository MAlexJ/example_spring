package com.malexj.training_course.profiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.profiles.bean.NotDevDatasourceConfig;
import com.malexj.training_course.profiles.config.ProfileManager;
import com.malexj.training_course.profiles.config.SetActiveProfilesConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring’s active profiles drive the behaviour of the @Profile annotation for enabling/disabling
 * beans. However, we may also wish to access the list of active profiles programmatically.
 *
 * <p>We have two ways to do it, using Environment or spring.profiles.active.
 */
public class GetActiveProfilesApp extends AbstractClass {

  /** 1. Using Environment */
  @Test
  public void usingEnvironment() {
    var ctx = new AnnotationConfigApplicationContext(SetActiveProfilesConfig.class);
    var profileManager = ctx.getBean(ProfileManager.class);
    println(profileManager.getActiveProfiles());
  }

  /** 2. Using spring.profiles.active */
  @Test
  public void usingSpringProfilesActive() {
    var ctx = new AnnotationConfigApplicationContext(SetActiveProfilesConfig.class);
    var bean = ctx.getBean(NotDevDatasourceConfig.class);
    println(bean.getActiveProfile());
    assertNotNull(bean);
  }
}
