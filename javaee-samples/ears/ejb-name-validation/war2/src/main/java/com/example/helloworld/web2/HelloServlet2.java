package com.example.helloworld.web2;

import com.example.helloworld.ejb.api.Hello;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class HelloServlet2 extends HttpServlet {

    @EJB(lookup = "java:global/helloworld/ejb-impl-1.0-SNAPSHOT/HelloImpl")
    private Hello hello;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(hello.helloAgain());
    }
}
