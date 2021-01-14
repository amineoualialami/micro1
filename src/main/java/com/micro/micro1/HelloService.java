package com.micro.micro1;

import com.amazonaws.xray.spring.aop.XRayEnabled;

import org.springframework.stereotype.Component;

@Component
@XRayEnabled
public class HelloService { 
  
    public String greetingHello() {
        return "Hello from micro1 service";
    }
  

}
