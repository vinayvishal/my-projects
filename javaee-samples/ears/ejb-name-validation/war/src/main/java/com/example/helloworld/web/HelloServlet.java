package com.example.helloworld.web;

import com.example.helloworld.ejb.api.Greeter;
import com.example.helloworld.ejb.api.Hello;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {

    @EJB(lookup = "java:global/helloworld/ejb-impl-1.0-SNAPSHOT/HelloImpl")
    private Hello defaultHello;

    @EJB(lookup = "java:global/helloworld/ejb-impl-1.0-SNAPSHOT/HelloImpl!com.example.helloworld.ejb.api.Hello")
    private Hello defaultHello2;

    @EJB(beanName = "helloThere")
    private Hello descriptorHello1;

    @EJB(beanName = "helloThereAgain")
    private Hello descriptorHello2;

    @EJB(beanName = "greeter")
    private Greeter greeter;

//    @EJB(beanName = "com_example_ejb_name_validation_hello")
//    private Hello sunEjbJarHello;


//    @EJB(beanName = "HelloImpl2")
//    private Hello descriptorHello2;

//    @EJB(lookup = "com_example_ejb_name_validation_hello")
//    private Hello subEjbDescriptorHello1;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DefaultHello -->" + defaultHello.hello() + "\n");
        resp.getWriter().write("DefaultHello2 -->" + defaultHello2.hello() + "\n");
        resp.getWriter().write("EjbJarDescriptorHello1 -->" + descriptorHello1.hello() + "\n");
        resp.getWriter().write("EjbJarDescriptorHello2 -->" + descriptorHello2.hello() + "\n");
//        resp.getWriter().write("SunEjbJarDescriptorHello -->" + sunEjbJarHello.hello() + "\n");
        resp.getWriter().write("Greeter -->" + greeter.greet() + "\n");

//        resp.getWriter().write("sunEjbDescriptorHello1 -->" + subEjbDescriptorHello1.hello() + "\n");

    }
}
