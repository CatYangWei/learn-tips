package com.yang.learn.base.threadpool.signal;

public class TwoThreadWaitNotify {
    static volatile int start = 1;
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread a1 = new Thread(new JsThread());
        Thread a2 = new Thread(new OsThread());
        a1.start();
        a2.start();
    }

    static class JsThread implements Runnable{
        @Override
        public void run() {
            try {
                while (TwoThreadWaitNotify.start<=100) {
                synchronized (TwoThreadWaitNotify.class) {
                        if (!TwoThreadWaitNotify.flag) {
                            System.out.println("基数--:" + TwoThreadWaitNotify.start);
                            TwoThreadWaitNotify.start++;
                            TwoThreadWaitNotify.flag = true;
                            TwoThreadWaitNotify.class.notify();
                        } else {
                            TwoThreadWaitNotify.class.wait();
                        }
                    }
                }
            } catch (Exception e) {

            }
        }

    }

    static class OsThread implements Runnable{
        @Override
        public void run() {
            try {
                while (TwoThreadWaitNotify.start<=100) {
                synchronized (TwoThreadWaitNotify.class){
                        if (TwoThreadWaitNotify.flag) {
                            System.out.println("偶数--:" + TwoThreadWaitNotify.start);
                            TwoThreadWaitNotify.start++;
                            TwoThreadWaitNotify.flag = false;
                            TwoThreadWaitNotify.class.notify();

                        } else {
                            TwoThreadWaitNotify.class.wait();
                        }
                    }
                }
            }catch (Exception e){

            }
        }
    }
}
