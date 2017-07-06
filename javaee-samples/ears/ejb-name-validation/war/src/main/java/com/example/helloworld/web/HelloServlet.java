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

    @EJB(beanName = "HelloImpl")
    private Hello defaultHello;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DefaultHello -->" + defaultHello.hello() + "\n");
    }
}

