package com.malexj.training_course.postprocessor.bean;

import com.malexj.training_course.base.AbstractClass;
import java.time.LocalTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Restaurant extends AbstractClass {

  private final LocalTime openTime;

  @Getter private final List<Food> menu;

  public List<String> getInfo() {
    println("Open time:" + openTime);
    println("Foods:" + menu);
    return menu.stream().map(Food::getType).toList();
  }
}
