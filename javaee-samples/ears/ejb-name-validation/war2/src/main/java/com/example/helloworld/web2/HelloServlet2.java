package com.example.helloworld.web2;

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
public class HelloServlet2 extends HttpServlet {
    @EJB (beanName = "greeter")
    private Greeter greeter;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(greeter.greet());
    }
}
