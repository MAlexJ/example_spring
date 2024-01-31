package com.malexj.spring_solution.autowired_annotation.bean;

import com.malexj.base.AbstractClass;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Parent extends AbstractClass {
  @Value("Parent Ann")
  private String name;

  private Child child;

  @Autowired
  public void setChild(Child child) {
    println("is autowired bean", this.getClass().getName(), "is null:", child.getParent() == null);
    this.child = child;
  }

  @Override
  public String toString() {
    return "{" + "name='" + name + '\'' + ", child=" + child.getName() + '}';
  }
}
