package com.lingyunxin.eurekacli;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class EurekaCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCliApplication.class, args);
    }


    @Value("${server.port}")
    String port;

    @RequestMapping("/hi/{name}")
    @HystrixCommand(fallbackMethod = "hiError")
    public String serverHi(@PathVariable(value = "name") String name){
        System.out.println("端口："+port);
        return "hi "+ name + ",i am from port :"+port;
    }
    @RequestMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "hiError")
    public String serverHello(@PathVariable(value = "name") String name){
        System.out.println("端口："+port);
        int i = 2/0;
        return "hi "+ name + ",i am from port :"+port;
    }
    public String hiError(String name){
        System.out.println("端口："+port);
        return "hi "+ name + ",bug bug bug";
    }
}
