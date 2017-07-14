package com.example.helloworld.appclient;

import com.example.helloworld.ejb.api.Hello;

import javax.ejb.EJB;


public class AppClient {

    @EJB
    private static Hello hello;

    public String sayHello(){
            System.out.println("My Bean going to say hello");
        return hello.hello();
    }

    public static void main(String[] args){
        AppClient appClient = new AppClient();
        System.out.println("Appclient saying " + appClient.sayHello());
    }

}