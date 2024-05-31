package com.malexj.training_course.profiles;

import static org.junit.jupiter.api.Assertions.*;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.profiles.config.SetActiveProfilesConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/** Set Profiles */
public class SetProfilesApp extends AbstractClass {

  /*
  1. Programmatically via WebApplicationInitializer Interface
  In web applications, WebApplicationInitializer can be used to configure the ServletContext programmatically.
  link: https://www.baeldung.com/spring-profiles#1-programmatically-via-webapplicationinitializer-interface
   */

  /*
  2. Programmatically via ConfigurableEnvironment
  We can also set profiles directly on the environment:
   */
  @Test
  public void programmaticallyViaConfigurableEnvironment() {
    var context = new AnnotationConfigApplicationContext(SetActiveProfilesConfig.class);
    var configurableEnvironment = context.getBean(ConfigurableEnvironment.class);

    // WTF!
    assertFalse(context.containsBean("devDatasourceConfig"));

    // 1. find all active profiles
    String[] activeProfiles = configurableEnvironment.getActiveProfiles();
    println(activeProfiles);
    assertArrayEquals(activeProfiles, new String[] {"dev", "test"});

    // 2. setup new profile
    configurableEnvironment.setActiveProfiles("my_profiles");

    // 3. verify profiles
    activeProfiles = configurableEnvironment.getActiveProfiles();
    println(activeProfiles);
    assertArrayEquals(activeProfiles, new String[] {"my_profiles"});
  }

  /*
  3.  Context Parameter in web.xml
   */

  /*
  4. VM System Parameter
  -Dspring.profiles.active=dev
   */

  /*
    5.  Environment Variable
  In a Unix environment, profiles can also be activated via the environment variable:
  export spring_profiles_active=dev
     */

  /*
    6. Maven Profile
  Spring profiles can also be activated via Maven profiles by specifying the spring.profiles.active configuration property.

  In every Maven profile, we can set a spring.profiles.active property:

  <profiles>
      <profile>
          <id>dev</id>
          <activation>
              <activeByDefault>true</activeByDefault>
          </activation>
          <properties>
              <spring.profiles.active>dev</spring.profiles.active>
          </properties>
      </profile>
      <profile>
          <id>prod</id>
          <properties>
              <spring.profiles.active>prod</spring.profiles.active>
          </properties>
      </profile>
  </profiles>
     */
}
