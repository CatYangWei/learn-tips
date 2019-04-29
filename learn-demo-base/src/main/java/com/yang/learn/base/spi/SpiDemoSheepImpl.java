package com.yang.learn.base.spi;

/**
 * @author coffezcat
 * @title: SpiDemoSheepImpl
 * @description: TODO
 * @date 2019/4/29 11:59
 */
public class SpiDemoSheepImpl implements SpiDemo{
    @Override
    public void say() {
        System.out.println("SHEEP");
    }
}
