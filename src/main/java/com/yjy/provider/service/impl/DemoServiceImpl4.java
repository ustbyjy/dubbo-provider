package com.yjy.provider.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yjy.provider.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceImpl4 implements DemoService {
    private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl4.class);

    @Override
    public String sayHello(String name) {
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        logger.info("isProviderSide：" + isProviderSide);
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        logger.info("clientIP：" + clientIP);
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        logger.info("application：" + application);

        return getClass().getName() + " Hello " + name;
    }
}
