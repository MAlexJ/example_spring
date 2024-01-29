package com.malexj.advanced.aop_proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.advanced.aop_proxy.aspect.LoggingAspect;
import com.malexj.advanced.aop_proxy.bean.Student;
import com.malexj.advanced.aop_proxy.config.AopProxyConfig;
import com.malexj.base.AbstractClass;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring AOP - Proxy with Aspects
 *
 * <p>Link to tutorial: <a
 * href="https://www.tutorialspoint.com/springaop/springaop_proxy.htm">Spring AOP - Proxy</a>
 */
public class ProxyClassWithAspectAppMain extends AbstractClass {

  @Test
  void runPoxyWithAspect() {
    // given
    ApplicationContext context = new AnnotationConfigApplicationContext(AopProxyConfig.class);

    // and
    int age = 10;
    var student = context.getBean("student", Student.class);
    student.setAge(age);

    // when: Create the Proxy Factory
    AspectJProxyFactory proxyFactory = new AspectJProxyFactory(student);

    // and: Add Aspect class to the factory
    proxyFactory.addAspect(LoggingAspect.class);

    // and:  Get the proxy object
    Student proxyStudent = proxyFactory.getProxy();

    // then:
    int proxyAfterAspectAge = proxyStudent.getAge();

    println("Proxy: ", proxyAfterAspectAge);
    assertEquals(20, proxyAfterAspectAge);
  }

  @Test
  void runPoxyWithoutConfiguration() {
    // given
    ApplicationContext context = new AnnotationConfigApplicationContext(AopProxyConfig.class);

    // and
    var student = context.getBean("alex", Student.class);

    // when: Create the Proxy Factory
    AspectJProxyFactory proxyFactory = new AspectJProxyFactory(student);
    Student proxyStudent = proxyFactory.getProxy();

    // then:
    int proxyAfterAspectAge = proxyStudent.getAge();
    println("Proxy: ", proxyAfterAspectAge);
    assertEquals(21, proxyAfterAspectAge);
  }
}
