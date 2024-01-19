package com.malexj.patterns;

public class ExpensiveObjectProxy implements ExpensiveObject {

  private static ExpensiveObject object;

  @Override
  public String process() {
    printLogs("Processing by proxy");
    if (object == null) {
      object = new ExpensiveObjectImpl();
    }
    return object.process();
  }
}
