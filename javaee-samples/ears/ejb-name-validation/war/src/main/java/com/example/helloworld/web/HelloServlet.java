package com.example.helloworld.web;

import com.example.helloworld.ejb.api.Hello;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {

    @EJB
    private Hello defaultHello;

//    @EJB(beanName = "helloEjbAnnotationName")
//    private Hello annotatedHello;

    @EJB(beanName = "helloThere")
    private Hello descriptorHello1;


//    @EJB(beanName = "HelloImpl2")
//    private Hello descriptorHello2;

//    @EJB(lookup = "ejb/com_example_ejb_name_validation_hello")
//    private Hello subEjbDescriptorHello1;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("DefaultHello -->" + defaultHello.hello() + "\n");
//        resp.getWriter().write("AnnotatedHello -->" + annotatedHello.hello() + "\n");
        resp.getWriter().write("DescriptorHello1 -->" + descriptorHello1.hello() + "\n");
//        resp.getWriter().write("DescriptorHello2 -->" + descriptorHello2.hello() + "\n");
//        resp.getWriter().write("sunEjbDescriptorHello1 -->" + subEjbDescriptorHello1.hello() + "\n");

        InitialContext ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        List<String> jndiMasterList = new ArrayList<>();
        List<String> jndiEntries = getJNDINames("", ctx, jndiMasterList);

        for(String jndiEntry : jndiMasterList){
            resp.getWriter().write(jndiEntry + "\n");
        }
//        NamingEnumeration<NameClassPair> list = null;
//        try {
//            list = ctx.list("");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        try {
//            while (list.hasMore()) {
//                resp.getWriter().write(list.next().getName() + "\n");
//            }
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//
//        NamingEnumeration<NameClassPair> ejbJndiNames = null;
//        try {
//            ejbJndiNames = ctx.list("ejb");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        try {
//            while (ejbJndiNames.hasMore()) {
//                resp.getWriter().write(ejbJndiNames.next().getName() + "\n");
//            }
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//
//        NamingEnumeration<NameClassPair> globalJndiNames = null;
//        try {
//            globalJndiNames = ctx.list("java:global");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        try {
//            while (globalJndiNames.hasMore()) {
//                resp.getWriter().write(globalJndiNames.next().getName() + "\n");
//            }
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }

    }

    private List<String> getJNDINames(String context, InitialContext ctx, List<String> list){
        list.add(context);
        try {
            NamingEnumeration<NameClassPair> jndiList = ctx.list(context);
            while(jndiList.hasMore()){
                NameClassPair nameClassPair = (NameClassPair) jndiList.next();
                System.out.println(nameClassPair);
                getJNDINames(nameClassPair.getName(), ctx, list);
            }
//                list.add(context);

        } catch (NamingException e) {
            e.printStackTrace();
        }

        return list;
    }
}
