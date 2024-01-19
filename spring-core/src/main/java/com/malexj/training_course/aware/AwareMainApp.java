package com.malexj.training_course.aware;

import static com.malexj.training_course.aware.bean.Chef.CHEF_MSG;
import static com.malexj.training_course.aware.bean.Waiter.WAITER_MSG;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.training_course.aware.bean.*;
import com.malexj.training_course.aware.config.AwareConfiguration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareMainApp {

  /**
   * 1. ApplicationContextAware.setApplicationContext( ApplicationContext ....)
   *
   * <p>Set up Chef bean inside Waiter bean
   */
  @Test
  public void testApplicationContextAware() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfiguration.class);
    var waiter = ctx.getBean(Waiter.class);

    // when
    String dish = "Salad";
    String order = waiter.takeOrder(dish);

    // then
    assertEquals(WAITER_MSG + ", " + String.format(CHEF_MSG, dish), order);
  }

  /**
   * 2. BeanFactoryAware.setBeanFactory( BeanFactory ....)
   *
   * <p>Set up Chef bean inside Customer bean
   */
  @Test
  public void testBeanFactoryAware() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfiguration.class);
    var customer = ctx.getBean(Customer.class);

    // when
    String dish = "Pizza";
    String result = customer.askChef(dish);

    // then
    assertEquals(String.format(CHEF_MSG, dish), result);
  }

  /**
   * 3. BeanNameAware.setBeanName(String name)
   *
   * <p>Find bean name in configuration
   */
  @Test
  public void testBeanNameAware() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfiguration.class);
    var waiter = ctx.getBean(Chef.class);

    // when
    String beanName = waiter.getBeanName();

    // then
    assertEquals("restaurantChef", beanName);
  }

  /**
   * 3. EnvironmentAware.setEnvironment(Environment environment)
   *
   * <p>Read env variables and config User bean
   */
  @Test
  public void testEnvironmentAware() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfiguration.class);
    var user = ctx.getBean(User.class);

    // when
    String javaVendor = user.javaVendorOsEnv();

    // then
    assertEquals("Oracle Corporation", javaVendor);
  }

  /**
   * 4. ResourceLoaderAware.setResourceLoader(ResourceLoader ....)
   *
   * <p>Add file with codes and read in bean
   */
  @Test
  public void testResourceLoaderAware() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfiguration.class);
    var admin = ctx.getBean(Admin.class);

    // when
    List<Integer> userCodes = admin.getUserCodes();

    // then
    assertEquals(userCodes.size(), 4);
  }
}
