package com.malexj.training_course.bean_scope.sample_2_java_config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.bean_scope.sample_2_java_config.bean.CatSingleton;
import com.malexj.training_course.bean_scope.sample_2_java_config.bean.DogPrototype;
import com.malexj.training_course.bean_scope.sample_2_java_config.bean.PetFactory;
import com.malexj.training_course.bean_scope.sample_2_java_config.config.PetConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Link to documentation: <a
 * href="https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html">Bean
 * Scope</a>
 *
 * <p>The Singleton Scope
 *
 * <p>Only one shared instance of a singleton bean is managed, and all requests for beans with an ID
 * or IDs that match that bean definition result in that one specific bean instance being returned
 * by the Spring container.
 *
 * <p>The Prototype Scope
 *
 * <p>The non-singleton prototype scope of bean deployment results in the creation of a new bean
 * instance every time a request for that specific bean is made. That is, the bean is injected into
 * another bean or you request it through a getBean() method call on the container. As a rule, you
 * should use the prototype scope for all stateful beans and the singleton scope for stateless
 * beans.
 */
public class BeanScopeApplication2 extends AbstractClass {

  @Test
  public void test() {
    ApplicationContext context = new AnnotationConfigApplicationContext(PetConfig.class);
    PetFactory petFactory = context.getBean(PetFactory.class);
    println(petFactory);

    // 1. singleton
    CatSingleton c1 = context.getBean(CatSingleton.class);
    CatSingleton c2 = context.getBean(CatSingleton.class);
    println("first singleton =", c1);
    println("second singleton =", c2, "\n");
    assertEquals(c1, c2);

    // 2. prototype
    DogPrototype d1 = context.getBean(DogPrototype.class);
    DogPrototype d2 = context.getBean(DogPrototype.class);
    DogPrototype d3 = context.getBean(DogPrototype.class);
    println("first prototype =", d1);
    println("second prototype =",d2);
    println("third prototype =", d3);
    assertNotEquals(d1, d2);
    assertNotEquals(d2, d3);
  }
}
