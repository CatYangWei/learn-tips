package com.yang.learn.dubbo.provider.impl;

import com.yang.learn.dubbo.provider.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String words) {
        System.out.println("receive:"+words);
        return "say:"+words;
    }
}
