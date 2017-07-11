package com.example.helloworld.ejb.impl;

import com.example.helloworld.ejb.api.Hello;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/*
 * a name has been given to this EJB, with this, now EJB will have
 * two names, namely the default one "HelloImpl" and custom one
 * "myEJB"
 */


/*
 * For Any component to be successful in injecting this EJB by its name "myEJB"
 * the resources being injected by the EJB itself (in this case the DataSource)
 * must fulfill following two criteria:
 * All defined names either implicit (default) or explicit (custom) must have a linked
 * resource either through annotations or through deployment descriptor.
 * In this case, since we are not specifying any name for this Stateless ejb,
 * there is only one implicit name for this ejb, which is same as the name of
 * the class. (HelloImpl)
 *
 */

@Stateless
public class HelloImpl implements Hello {

    /*
     * A jms queue resource should be pre-configured and bound to jndi name:
     * java:comp/env/jdbc/appDB
     */
    @Resource(name="jdbc/appDB")
    private javax.sql.DataSource ds;
    
    @Override
    public String hello() {
        return "Hello World!";
    }

}
