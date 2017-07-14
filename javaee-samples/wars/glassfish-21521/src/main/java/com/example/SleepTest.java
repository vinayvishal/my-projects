package com.example;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="SleepTest", urlPatterns="/sleep")
public class SleepTest extends HttpServlet {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
       String timeParam = req.getParameter("time");
       int sleep = 1;
       try {
           sleep = Integer.parseInt(timeParam);
       } catch (Exception e) {
           
       }
       
       try {
           Thread.sleep(sleep*1000L);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       
       res.getWriter().println(sleep+" seconds sleeeped.");
   }

}
