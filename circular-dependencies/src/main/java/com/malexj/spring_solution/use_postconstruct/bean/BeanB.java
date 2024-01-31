package com.malexj.spring_solution.use_postconstruct.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class BeanB {

  private BeanA a;
}
