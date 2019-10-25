package com.yang.learn.base.netty;

import io.netty.channel.EventLoopGroup;

/**
 * @author coffezcat
 * @title: Example
 * @description: TODO
 * @date 2019-09-06 17:42
 */
public class Example {
    public static void main(String[] args) {
        String str = "-----------";
        char[] chars = str.toCharArray();
        chars[3] = 'B';
        String str1 = new String(chars);
        System.out.println(str1);

    }
}
