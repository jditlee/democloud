package com.lingyunxin.servicefeign.controller;

import com.lingyunxin.servicefeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping("/hi/{name}")
    public String sayHi(@PathVariable("name")String name){
        return feignService.sayHiFromEurekaCli(name);
    }

}
