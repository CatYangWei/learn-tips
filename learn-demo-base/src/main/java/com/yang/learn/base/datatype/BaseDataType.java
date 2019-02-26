package com.yang.learn.base.datatype;

public class BaseDataType {
    public static void main(String[] args) {
        Integer i = 128;
        Integer j = 128;
        System.out.println(i==j);

        String s1= "s";
        String s2 = "s";
        System.out.println(s1==s2);

        String s3 = new String("s");
        String s4 = new String("s");
        System.out.println(s3==s4);
        int xx = 0x12;
        int xxy = 012;
        System.out.println(xxy);
    }

}
