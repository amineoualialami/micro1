package com.micro.micro1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro1")
public class HelloRestController { 

  @Autowired
  private HelloService helloService;
  
  
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetinhellog() {
        return helloService.greetingHello();
    }
  

}
