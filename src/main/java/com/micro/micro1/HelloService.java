package com.micro.micro1;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.amazonaws.xray.proxies.apache.http.HttpClientBuilder;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@XRayEnabled
public class HelloService {

    @Autowired
    private ProcessService processService;

    public String greetingHello() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://micro2-service.local:8888/micro2/hello");
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            response.close();
            return "calling from micro 1 - " + result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void processRequest(RequestDto requestDto) throws Exception {
        processService.processRequest(requestDto);
        processRequestMicro2(requestDto);
    }

    private void processRequestMicro2(RequestDto requestDto) throws JsonProcessingException,
            UnsupportedEncodingException, ClientProtocolException, ParseException, IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://micro2-service.local:8888/micro2/process");
        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String requestDtoString = mapper.writeValueAsString(requestDto);
        httpPost.setEntity(new StringEntity(requestDtoString));
        CloseableHttpResponse response = null;
        response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        response.close();
         
    }

  

}
