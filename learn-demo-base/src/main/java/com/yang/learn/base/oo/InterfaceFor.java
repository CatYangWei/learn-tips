package com.yang.learn.base.oo;

public class InterfaceFor {

    public static void main(String[] args) {
        new AppleImpl().eat();
    }

    static class AppleImpl implements Apple{
        @Override
        public void eat() {
            System.out.println("eat");
        }
    }

    private interface Apple{
        void eat();
    }
}
