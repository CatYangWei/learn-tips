package com.yang.learn.base.thread;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangweia
 * @title
 * @date 2019年03月28日
 * @since v1.0.0
 */
public class Boot {


    static class MyThreadFactory implements ThreadFactory{
        AtomicInteger atomicInteger = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            ThreadGroup group = new ThreadGroup("yangwei");
            Thread t = new Thread(group,r,"yangwei"+atomicInteger.getAndAdd(1));
            return t;
        }
    }

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,10,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(50),new MyThreadFactory());
        for (int i=0;i<20;i++){
            final AtomicInteger atomicInteger = new AtomicInteger(i);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (Exception e){

                    }finally {
                        System.err.println("执行完成"+atomicInteger.get());
                    }

                }
            });
        }
        System.out.println(1111111111);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                executor.shutdown();
                while (true) {
                    try {
                        System.out.println("try terminated");
                        if (executor.awaitTermination(2, TimeUnit.SECONDS)) {
                            System.out.println("线程池停成功++");
                            break;
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }));
    }
}
