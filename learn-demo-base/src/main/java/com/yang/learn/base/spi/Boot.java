package com.yang.learn.base.spi;

import java.util.ServiceLoader;

/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/4/29 12:35
 */
public class Boot {
    public static void main(String[] args) {
        ServiceLoader<SpiDemo> loaders = ServiceLoader.load(SpiDemo.class);
        for (SpiDemo helloService : loaders) {
            helloService.say();
        }
    }
}
