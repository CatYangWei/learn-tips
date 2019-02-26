package com.yang.learn.base.oo;

public abstract class AbstractClassFor {
    public static void main(String[] args) {
        char[] chars = {'a','b','c'};
        replace(chars);
        System.out.println(chars);
    }

    public static void replace(char[] chars){
        chars[0] = 'g';
    }
}
