package com.micro.micro1;

import javax.servlet.Filter;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsXRayConfig {

  @Bean
  public Filter TracingFilter() {
    return new AWSXRayServletFilter("micro1-app");
  }
}