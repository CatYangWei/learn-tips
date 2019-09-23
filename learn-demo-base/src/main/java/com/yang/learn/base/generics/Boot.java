package com.yang.learn.base.generics;
import javax.sql.XADataSource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author coffezcat
 * @title: Boot
 * @description: TODO
 * @date 2019/5/13 10:03
 */
public class Boot {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1000);
        AtomicLong atomicLong = new AtomicLong(0);
        long begin = System.currentTimeMillis();
        Thread[] threads = new Thread[1000];
        for(int i=0;i<1000;i++){
            threads[i] = new Thread(new Job(atomicLong,countDownLatch));
        }
        for(int i=0;i<1000;i++){
            threads[i].start();
        }


        try {
            countDownLatch.await();
        }catch (Exception e){

        }
        long end = System.currentTimeMillis();
        System.out.println("result:"+atomicLong.get());
        System.out.println("costTime:"+(end-begin));
    }

    static class Job implements Runnable{
        private AtomicLong atomicLong;
        CountDownLatch countDownLatch;

        public Job(AtomicLong atomicLong,CountDownLatch latch){
            this.atomicLong = new AtomicLong(0);
            countDownLatch = latch;
        }

        @Override
        public void run() {
            for (int i=0;i<1000000;i++)
            atomicLong.addAndGet(1);
            countDownLatch.countDown();
        }
    }
}
