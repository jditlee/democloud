package com.lingyunxin.eurekacli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCliApplication.class, args);
    }


    @Value("${server.port}")
    String port;

    @RequestMapping("/hi/{name}")
    public String serverHi(@PathVariable(value = "name") String name){
        System.out.println("端口："+port);
        return "hi "+ name + ",i am from port :"+port;
    }
}
