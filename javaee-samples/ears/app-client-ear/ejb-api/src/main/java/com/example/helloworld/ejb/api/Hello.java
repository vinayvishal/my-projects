package com.example.helloworld.ejb.api;

import javax.ejb.Remote;

@Remote
public interface Hello {
    String hello();
}
