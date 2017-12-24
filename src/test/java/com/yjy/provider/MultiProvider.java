package com.yjy.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultiProvider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-provider.xml"});
        context.start();
        System.out.println("服务开始运行...");
        System.in.read(); // 按任意键退出
    }
}
