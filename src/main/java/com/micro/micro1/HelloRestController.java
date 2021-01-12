package com.micro.micro1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro1")
public class HelloRestController { 
  
  
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetinhellog() {
        return "Hello from micro1";
    }
  

}
