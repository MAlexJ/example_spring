package com.malexj.spring_solution.use_postconstruct.bean;

import javax.annotation.PostConstruct;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
@ToString(exclude = "b")
@RequiredArgsConstructor
public class BeanWithPostConstruct {

  private String name;

  private final SimpleBean b;

  @PostConstruct
  public void init() {
    b.setA(this);
    name = b.getName() + "_simple";
  }
}
