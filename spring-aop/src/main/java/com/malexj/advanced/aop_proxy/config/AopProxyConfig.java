package com.malexj.advanced.aop_proxy.config;

import com.malexj.advanced.aop_proxy.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.malexj.advanced.aop_proxy")
public class AopProxyConfig {

  @Bean
  public Student alex() {
    var student = new Student();
    student.setAge(21);
    return student;
  }
}
