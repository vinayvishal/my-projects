package com.example.helloworld.ejb.impl;

import com.example.helloworld.ejb.api.Hello;

import javax.annotation.Resource;
import javax.ejb.Stateless;

/*
 * a name has been given to this EJB, with this, now EJB will have
 * two names, namely the default one "HelloImpl" and custom one
 * "myEJB"
 */


/*
 * For Any component to be successful in injecting this EJB by its name "myEJB"
 * the resources being injected by the EJB itself must fulfill following two criteria:
 * All defined names either implicit (default) or explicit (custom) must have a linked
 * resource either through annotations or through deployment descriptor.
 *
 */

@Stateless(name="myEJB")
public class HelloImpl implements Hello {
    
    @Override
    public String hello() {
        return "Hello World!";
    }

}
