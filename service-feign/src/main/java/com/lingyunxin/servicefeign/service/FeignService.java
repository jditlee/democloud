package com.lingyunxin.servicefeign.service;

import com.lingyunxin.servicefeign.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-cli",fallback = FeignServiceImpl.class)
public interface FeignService {

    @RequestMapping(value = "/hi/{name}",method = RequestMethod.GET)
    String sayHiFromEurekaCli(@PathVariable("name") String name);
}
