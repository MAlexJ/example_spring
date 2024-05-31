package com.malexj.training_course.profiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.profiles.bean.NotDevDatasourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Declare Profiles in XML, link https://www.baeldung.com/spring-profiles#declare-profiles-in-xml
 *
 * <p>Profiles can also be configured in XML. The <beans> tag has a profile attribute, which takes
 * comma-separated values of the applicable profiles:
 */
public class DeclareProfilesInXmlApp extends AbstractClass {

  @Test
  public void declareProfilesInXML() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    assertTrue(ctx.containsBean("notDevDatasourceConfig"));
    var bean = ctx.getBean(NotDevDatasourceConfig.class);
    assertNotNull(bean);
  }
}
