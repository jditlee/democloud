package com.lingyunxin.serviceribbon.Controller;

import com.lingyunxin.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi/{name}")
    public String hi(@PathVariable("name")String name){
        return helloService.hiService(name);
    }

}
