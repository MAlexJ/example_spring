package com.malexj.training_course.proxy.bean;

import lombok.Getter;

public class Customer {

    @Getter
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(IWaiter waiter){
        waiter.serve(name);
    }

}
