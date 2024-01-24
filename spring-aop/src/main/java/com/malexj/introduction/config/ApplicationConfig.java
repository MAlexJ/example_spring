package com.malexj.introduction.config;

import com.malexj.introduction.bean.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.malexj.introduction")
public class ApplicationConfig {

  @Value("${student.firstname:FIRST_NAME}")
  private String firstName;

  @Value("${student.lastname:LAST_NAME}")
  private String lastName;

  @Bean
  public Student student() {
    return new Student(firstName, lastName);
  }
}
