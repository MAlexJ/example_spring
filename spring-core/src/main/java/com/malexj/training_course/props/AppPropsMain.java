package com.malexj.training_course.props;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.props.annotation.AnnotationPropsConfiguration;
import com.malexj.training_course.props.bean.Restaurant;
import com.malexj.training_course.props.properties.PropsPropertySourcesConfiguration;
import com.malexj.training_course.props.yaml.YamlPropertySourcesConfiguration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppPropsMain extends AbstractClass {

  @Test
  public void runAllTests() {
    testAnnotationPropertiesConfiguration();
    testPropertySourcesPlaceholderConfigurer();
    testYamlPropertySourcesPlaceholderConfigurer();
  }

  /** Configuration properties with @PropertySource("classpath:application.properties") */
  @Test
  public void testAnnotationPropertiesConfiguration() {
    println("1. Test: @PropertySource('classpath:application.properties') configuration");
    // given
    var restaurant = createContextAndFindRestaurantBean(AnnotationPropsConfiguration.class);
    test(restaurant);
  }

  /** Configuration with @Bean PropertySourcesPlaceholderConfigurer(){.....} */
  @Test
  public void testPropertySourcesPlaceholderConfigurer() {
    println("2. Test: @Bean PropertySourcesPlaceholderConfigurer(){.....}");
    // given
    var restaurant = createContextAndFindRestaurantBean(PropsPropertySourcesConfiguration.class);
    test(restaurant);
  }

  @Test
  public void testYamlPropertySourcesPlaceholderConfigurer() {
    println(
        "3. Test: @Bean PropertySourcesPlaceholderConfigurer with YamlPropertySourcesConfiguration");
    // given
    var restaurant = createContextAndFindRestaurantBean(YamlPropertySourcesConfiguration.class);
    test(restaurant);
  }

  private Restaurant createContextAndFindRestaurantBean(Class<?>... componentClasses) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(componentClasses);
    return ctx.getBean(Restaurant.class);
  }

  private void test(Restaurant restaurant) {
    // when
    String info = restaurant.info();
    List<String> menu = restaurant.menu();
    String description = restaurant.description();

    // then
    assertEquals(String.format(Restaurant.INFO_FORMAT, "French Restaurant", 50), info);
    // and
    assertTrue(menu.contains("Spaghetti"));
    assertTrue(menu.contains("Grilled Salmon"));
    // and
    assertEquals(String.format("Name: %s capacity: %s", "French Restaurant", 50), description);
  }
}
