package com.lingyunxin.servicefeign.service.impl;

import com.lingyunxin.servicefeign.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String sayHiFromEurekaCli(String name) {
        return "sorry,"+name+",error error error !!!!!!!!!!!";
    }
}
