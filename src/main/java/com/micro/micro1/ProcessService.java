package com.micro.micro1;



import com.amazonaws.xray.spring.aop.XRayEnabled;

import org.springframework.stereotype.Component;

@Component
@XRayEnabled
public class ProcessService {

    public void processRequest(RequestDto requestDto) throws Exception {
        if(!requestDto.getParam1().isEmpty()){
            throw new Exception("some business exception");
        }
       
    }

  

}
