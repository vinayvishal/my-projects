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

    @EJB(lookup = "java:global/helloworld/ejb-impl-1.0-SNAPSHOT/HelloImpl")
    private Hello defaultHello;

    @EJB(lookup = "java:global/helloworld/ejb-impl-1.0-SNAPSHOT/HelloImpl!com.example.helloworld.ejb.api.Hello")
    private Hello defaultHello2;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DefaultHello -->" + defaultHello.hello() + "\n");
        resp.getWriter().write("DefaultHello2 -->" + defaultHello2.hello() + "\n");
    }
}

