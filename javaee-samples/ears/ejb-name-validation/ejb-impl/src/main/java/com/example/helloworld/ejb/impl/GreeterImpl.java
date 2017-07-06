package com.example.helloworld.ejb.impl;

import com.example.helloworld.ejb.api.Greeter;
import com.example.helloworld.ejb.api.Hello;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by vinay on 5/7/17.
 */
@Stateless(name = "greeter")
public class GreeterImpl implements Greeter {

    @EJB(beanName = "HelloImpl")
    private Hello helloEjbJar;

    public String greet(){
        return "Greeting from a bean having beanName as HelloImpl, " +
                "this is default and hasn't been defined in any of the descriptor" + helloEjbJar.hello();
    }
}



