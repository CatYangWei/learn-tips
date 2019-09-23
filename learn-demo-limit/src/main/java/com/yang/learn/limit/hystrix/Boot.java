package com.yang.learn.limit.hystrix;

import com.yang.learn.limit.hystrix.service.HelloWorldCommand;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/4/30 17:44
 */
public class Boot {
    public static void main(String[] args)throws Exception {
        //每个Command对象只能调用一次,不可以重复调用,
        //重复调用对应异常信息:This instance can only be executed once. Please instantiate a new instance.
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Synchronous-hystrix");
        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = helloWorldCommand.execute();
        System.out.println("result=" + result);
//
//        helloWorldCommand = new HelloWorldCommand("Asynchronous-hystrix");
//        //异步调用,可自由控制获取结果时机,
//        Future<String> future = helloWorldCommand.queue();
//        //get操作不能超过command定义的超时时间,默认:1秒
//        result = future.get(100, TimeUnit.MILLISECONDS);
//        System.out.println("result=" + result);
//        System.out.println("mainThread=" + Thread.currentThread().getName());
    }
}
