package com.yang.learn.base.collections;

/**
 * @author coffezcat
 * @title: HashBoot
 * @description: TODO
 * @date 2019/5/31 15:13
 */
public class HashBoot {
    public static void main(String[] args) {
        int capacity = 8,newCapacity = 16;
        for (int i=0;i<32;i++){
            System.out.println(i+":"+(i^capacity));
        }
    }
}
