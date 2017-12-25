package com.yjy.provider.service.impl;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public class DemoServiceGenericImpl implements GenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if ("sayHello".equals(method)) {
            return "Welcome " + args[0];
        }
        return null;
    }
}
