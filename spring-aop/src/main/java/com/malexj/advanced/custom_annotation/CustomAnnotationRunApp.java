package com.malexj.advanced.custom_annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.advanced.custom_annotation.bean.DatabaseService;
import com.malexj.advanced.custom_annotation.config.CustomAnnotationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomAnnotationRunApp {

  @Test
  void runServiceWithTx() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(CustomAnnotationConfig.class);

    // when
    var service = ctx.getBean(DatabaseService.class);

    // then
    assertEquals("method2", service.method1());
  }
}
