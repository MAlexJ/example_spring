package com.malexj.training_course.proxy.bean;

import java.util.concurrent.TimeUnit;

public record Waiter(String name) implements IWaiter {

  @Override
  public void serve(String customerName) {
    System.out.println(" 1.1. " + name + " is serving customer - " + customerName);
    try {
      TimeUnit.SECONDS.sleep(7);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(" 1.2. " + name + " is free, after customer - " + customerName);
  }
}
