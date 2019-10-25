package com.yang.learn.base.enums;

/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/5/13 15:18
 */
public class Boot {

    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Boot ex =  new Boot();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}
