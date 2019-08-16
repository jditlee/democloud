package com.lingyunxin.service_zipkin2;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServiceZipkin2Application {

    public static final Logger log = Logger.getLogger(ServiceZipkin2Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkin2Application.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

    @RequestMapping("/hi")
    public String callTrace(){
        log.log(Level.INFO,"hi is being called");
        return "hello , i am serviceZipkin2 of 222 hi";
    }
    @RequestMapping("/miya")
    public String info(){
        log.log(Level.INFO,"info is being called");
        return restTemplate.getForObject("http://localhost:8770/info",String.class);
    }

}
