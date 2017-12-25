package com.yjy.provider.service.impl;

import com.yjy.provider.service.DemoService;

public class DemoServiceImpl3 implements DemoService {

    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getClass().getName() + " Hello " + name;
    }
}
