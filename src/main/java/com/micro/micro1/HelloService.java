package com.micro.micro1;

import java.io.InputStream;
import java.util.Map;

import com.amazonaws.xray.proxies.apache.http.HttpClientBuilder;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
@XRayEnabled
public class HelloService { 
  
    public String greetingHello() {        
            CloseableHttpClient httpclient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("http://micro2-service.local:8888/micro2/hello");
            CloseableHttpResponse response = null;
            try {
              response = httpclient.execute(httpGet);
              HttpEntity entity = response.getEntity();
              String result = EntityUtils.toString(entity);
              response.close();
              return "calling from micro 1 - "+result;
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        return null;
    }
  

}
