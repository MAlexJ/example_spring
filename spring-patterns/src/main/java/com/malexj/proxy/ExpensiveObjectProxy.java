package com.malexj.proxy;

public class ExpensiveObjectProxy implements ExpensiveObject {

    private ExpensiveObject object;

    @Override
    public String process() {
        printLogs("Processing by proxy");
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        return object.process();
    }
}
