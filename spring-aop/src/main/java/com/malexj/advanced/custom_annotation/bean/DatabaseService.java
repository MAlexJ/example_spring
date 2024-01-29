package com.malexj.advanced.custom_annotation.bean;

import com.malexj.advanced.custom_annotation.annotation.MyTransaction;
import com.malexj.base.AbstractClass;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService extends AbstractClass {

  @MyTransaction
  public String method1() {
    println("2. method1");
    return method2();
  }

  @MyTransaction
  public String method2() {
    println("3. method2");
    return "method2";
  }
}
