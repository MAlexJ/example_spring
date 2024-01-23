package com.malexj.introduction.bean;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.annotation.MyAnnotation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@EqualsAndHashCode(callSuper = false)
public class Shop extends AbstractClass {

  @Value("${bean.name:.my_shop}")
  private String name;

  public String info(String data) {
    println("  >> shop info:", data);
    return data;
  }

  @MyAnnotation(name = "new info")
  public String addInfo(String data) {
    println("  >> add info:", data + name);
    return data + name;
  }
}
