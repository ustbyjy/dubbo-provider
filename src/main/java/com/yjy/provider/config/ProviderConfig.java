package com.yjy.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.yjy.provider.service.DemoService;
import com.yjy.provider.service.impl.DemoServiceImpl;

import java.io.IOException;

public class ProviderConfig {

    public static void main(String[] args) throws IOException {
        // 服务实现
        DemoService demoService = new DemoServiceImpl();

        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("hello-world-app");

        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("multicast");
        registryConfig.setAddress("224.5.6.7:1234");
        registryConfig.setUsername("aaa");
        registryConfig.setPassword("bbb");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(10080);
        protocol.setThreads(200);

        // 服务提供者暴露服务配置
        ServiceConfig<DemoService> service = new ServiceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(applicationConfig);
        service.setRegistry(registryConfig); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(DemoService.class);
        service.setRef(demoService);
        service.setVersion("1.0.0");

        // 暴露及注册服务
        service.export();
        System.in.read(); // 按任意键退出
    }
}
