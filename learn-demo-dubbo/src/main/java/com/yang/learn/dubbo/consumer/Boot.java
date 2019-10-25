package com.yang.learn.dubbo.consumer;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.annotation.Service;
import com.yang.learn.dubbo.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Service
public class Boot {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
        System.in.read();

    }
}
