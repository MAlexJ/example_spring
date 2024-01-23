package com.malexj;

public interface ExpensiveObject {
  String process();

   default void printLogs(String logs) {
    System.out.println(logs);
  }
}
