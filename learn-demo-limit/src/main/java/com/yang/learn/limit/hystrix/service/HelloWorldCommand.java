package com.yang.learn.limit.hystrix.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author coffezcat
 * @title: HelloWorldCommand
 * @description: TODO
 * @date 2019/4/30 17:47
 */
public class HelloWorldCommand extends HystrixCommand<String> {

    private String name;

    public HelloWorldCommand(String name){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }
    @Override
    protected String run() throws Exception {
        // 依赖逻辑封装在run()方法中
       return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }
}
