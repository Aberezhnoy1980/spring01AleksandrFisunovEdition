package ru.aberezhnoy.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;

    @Autowired
    public void setB(B b) {
        this.b = b;
    }

//    @Autowired
//    public A(B b) {
//        this.b = b;
//    }
}
