package com.malexj.spring_solution.autowired_annotation.bean;

import com.malexj.base.AbstractClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@EqualsAndHashCode(callSuper = false)
public class Child extends AbstractClass {

  @Value("${child.name:Baby}")
  private String name;

  private Parent parent;

  @Autowired
  public void setParent(Parent parent) {
    println("is autowired bean", this.getClass().getName(), "is null:", parent.getChild() == null);
    this.parent = parent;
  }

  @Override
  public String toString() {
    return "{" + "name=" + name + ", parent=" + parent.getName() + '}';
  }
}
