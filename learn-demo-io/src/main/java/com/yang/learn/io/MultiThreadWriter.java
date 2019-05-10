package com.yang.learn.io;

import com.yang.learn.io.util.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author coffezcat
 * @title: MultiThreadWriter
 * @description: TODO
 * @date 2019/5/10 11:28
 */
@Slf4j
public class MultiThreadWriter {
    private static final String  TARGET_PATH = "D:\\data\\home\\generate\\num.txt";
    private static int threadNum = 10;

    public static void main(String[] args)throws Exception {
        FileUtil.makeFile(TARGET_PATH);
        FileWriter fw = new FileWriter(new File(TARGET_PATH),true);
        final BufferedWriter bw = new BufferedWriter(fw);
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=1;i<=threadNum;i++){
            executorService.execute(new Writer(i,bw,countDownLatch));
        }
        countDownLatch.await();
        bw.close();
        fw.close();
        log.info("file make complete!!");
        executorService.shutdown();
    }


    static class Writer implements Runnable{

        int num;
        BufferedWriter bw;
        CountDownLatch countDownLatch;

        public Writer(int num,BufferedWriter bw,CountDownLatch countDownLatch){
            this.num = num;
            this.bw = bw;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("开始写入数据");
                log.info("{}-开始写入数据",num);
                for (int i = 0; i < 100; i++) {
                    bw.write(num + "-" + i+"\r\n");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }
    }
}
