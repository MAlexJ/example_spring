package com.malexj.training_course.props.bean;

import com.malexj.training_course.base.AbstractClass;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Restaurant extends AbstractClass {
  public static final String INFO_FORMAT = "Restaurant name: %s, capacity: %s";

  @Value("${restaurant.name}")
  private String name;

  @Value("${restaurant.capacity}")
  private int capacity;

  @Value(value = "#{'${restaurant.menu}'.split(',')}")
  private List<String> menu;

  @Value("${restaurant.description}")
  private String description;

  public String info() {
    String info = String.format(INFO_FORMAT, name, capacity);
    println("Info:", info);
    return info;
  }

  public List<String> menu() {
    println("Menu:", menu);
    return menu;
  }

  public String description() {
    println("Description:", description);
    return description;
  }
}
