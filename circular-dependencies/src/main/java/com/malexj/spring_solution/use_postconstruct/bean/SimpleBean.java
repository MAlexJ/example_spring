package com.malexj.spring_solution.use_postconstruct.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SimpleBean {

  @Value("${simple.bean.name}")
  private String name;

  private BeanWithPostConstruct a;
}
