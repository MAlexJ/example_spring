package com.malexj.proxy;

public interface ExpensiveObject {

    String process();

    default void printLogs(String logs) {
        System.out.println(logs);
    }
}
