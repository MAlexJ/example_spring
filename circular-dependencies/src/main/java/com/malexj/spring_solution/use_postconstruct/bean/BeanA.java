package com.malexj.spring_solution.use_postconstruct.bean;

import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class BeanA {

  private final BeanB b;

  @PostConstruct
  public void init() {
    b.setA(this);
  }
}
