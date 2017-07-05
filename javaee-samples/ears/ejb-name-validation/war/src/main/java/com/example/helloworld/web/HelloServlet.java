package com.example.helloworld.web;

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

//    @EJB
//    private Hello defaultHello;

    @EJB(beanName = "helloEjbAnnotationName")
    private Hello annotatedHello;

    @EJB(beanName = "HelloImpl")
    private Hello descriptorHello1;


    @EJB(beanName = "HelloImpl2")
    private Hello descriptorHello2;

//    @EJB(lookup = "ejb/com_example_ejb_name_validation_hello")
//    private Hello subEjbDescriptorHello1;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("DefaultHello -->" + defaultHello.hello() + "\n");
        resp.getWriter().write("AnnotatedHello -->" + annotatedHello.hello() + "\n");
        resp.getWriter().write("DescriptorHello1 -->" + descriptorHello1.hello() + "\n");
//        resp.getWriter().write("DescriptorHello2 -->" + descriptorHello2.hello() + "\n");
//        resp.getWriter().write("sunEjbDescriptorHello1 -->" + subEjbDescriptorHello1.hello() + "\n");

    }
}
