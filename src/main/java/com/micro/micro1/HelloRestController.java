package com.micro.micro1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro1")
public class HelloRestController { 

  @Autowired
  private HelloService helloService;
  
  
  @GetMapping(value = "/hello")
  public String greetinhellog() {
      return helloService.greetingHello();
  }

  @PostMapping(value = "/process")
  public void processRequest(@RequestBody  RequestDto requestDto) throws Exception {
      helloService.processRequest(requestDto);
  }
  

  
  

}
