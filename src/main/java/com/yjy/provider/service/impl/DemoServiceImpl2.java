package com.yjy.provider.service.impl;

import com.yjy.provider.service.DemoService;

public class DemoServiceImpl2 implements DemoService {

    @Override
    public String sayHello(String name) {
        return getClass().getName() + " Hello " + name;
    }
}
