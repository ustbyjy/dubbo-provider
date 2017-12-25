package com.yjy.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderTestContext {
    private static Logger logger = LoggerFactory.getLogger(ProviderTestContext.class);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-provider-context.xml"});
        context.start();
        logger.info("服务开始运行...");
        System.in.read(); // 按任意键退出
    }
}
