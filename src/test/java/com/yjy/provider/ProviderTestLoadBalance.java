package com.yjy.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderTestLoadBalance {
    private static Logger logger = LoggerFactory.getLogger(ProviderTestLoadBalance.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-provider.xml"});
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-provider2.xml"});
        context1.start();
        context2.start();
        logger.info("服务开始运行...");
        System.in.read(); // 按任意键退出
    }
}
