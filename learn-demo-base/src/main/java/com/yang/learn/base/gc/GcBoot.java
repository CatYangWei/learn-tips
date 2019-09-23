package com.yang.learn.base.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author coffezcat
 * @title: GcBoot
 * @description: TODO
 * @date 2019/6/26 11:24
 */
public class GcBoot {
    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
                try {
                    System.out.println("sub1 main thread");
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            while (true){
                try {
                    System.out.println("output thread");
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();
        //主线程

        List<Byte[]> list = new ArrayList<>();
        while (true){
            try {
                Byte[] bytes = new Byte[1024*1024*2];
                list.add(bytes);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("oom-thread");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
