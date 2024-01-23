package com.malexj.introduction.bean;

import com.malexj.introduction.base.AbstractClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Data
@Component
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractClass {

  private String name;

  public String info(String data) {
    println(">> Student:", data);
    return data;
  }
}
