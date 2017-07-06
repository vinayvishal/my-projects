package com.example.helloworld.ejb.impl;

import com.example.helloworld.ejb.api.Hello;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Queue;

@Stateless
public class HelloImpl implements Hello {

    @Resource(name="myQueue")
    private javax.jms.Queue queue1;
    
    @Override
    public String hello() {
        return "Hello World!";
    }

    @Override
    public String helloAgain() {
        return "Hello World Again!!!";
    }
}
