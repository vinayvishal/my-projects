package com.example.helloworld.ejb.impl;

import com.example.helloworld.ejb.api.Hello;
import javax.ejb.Stateless;

@Stateless(name="helloEjbAnnotationName")
public class HelloImpl implements Hello {
    
    @Override
    public String hello() {
        return "Hello World!";
    }

    @Override
    public String helloAgain() {
        return "Hello World Again!!!";
    }
}
