package com.example.helloworld.ejb.impl;

import com.example.helloworld.ejb.api.Hello;

import javax.ejb.Stateless;

/*
 * a name has been given to this EJB, with this, now EJB will have
 * two names, namely the default one "HelloImpl" and custom one
 * "myEJB"
 */


@Stateless(name = "myBean")
public class HelloImpl implements Hello {

    @Override
    public String hello() {
        return "Hello World!";
    }

}
