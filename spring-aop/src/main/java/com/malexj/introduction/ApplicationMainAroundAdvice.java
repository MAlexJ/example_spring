package com.malexj.introduction;

import com.malexj.introduction.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Around Advice:
 *
 * <p>1. Most powerful advice type, allowing you to completely control the target method's
 * invocation.
 *
 * <p>2. Wraps around the target method, allowing you to execute custom logic before and after the
 * method invocation.
 */
public class ApplicationMainAroundAdvice {

  @Test
  public void testAround() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    // when

    // then
  }
}
