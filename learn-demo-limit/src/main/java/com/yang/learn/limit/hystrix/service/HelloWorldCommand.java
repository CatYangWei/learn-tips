package com.yang.learn.limit.hystrix.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * @author coffezcat
 * @title: HelloWorldCommand
 * @description: TODO
 * @date 2019/4/30 17:47
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private String name;

    private static Setter setter;
    static {
        setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(500));
    }

    public HelloWorldCommand(String name){
        super(setter);
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "Fallback";
    }

    @Override
    protected String run() throws Exception {
        TimeUnit.MILLISECONDS.sleep(600);
        // 依赖逻辑封装在run()方法中
       return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }
}
