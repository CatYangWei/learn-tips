package com.yang.learn.base.reflect;

import java.lang.reflect.Field;

/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/6/5 14:52
 */
public class Boot {
    public static void main(String[] args)throws Exception {
        Class clazz = Child.class;

        Child child = (Child)clazz.newInstance();
        Field[] fields=  clazz.getDeclaredFields();
        for (Field f:fields) {
            f.set(child,"11");
        }

        Class superClazz =  clazz.getSuperclass();
        for (Field f:superClazz.getDeclaredFields()) {
            f.set(child,"121");
        }

        System.out.println(child);
    }
}
