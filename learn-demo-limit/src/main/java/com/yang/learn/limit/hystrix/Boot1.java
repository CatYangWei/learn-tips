package com.yang.learn.limit.hystrix;

import com.yang.learn.limit.hystrix.service.HelloWorldCommand;
import rx.Observable;
import rx.functions.Action1;

/**
 * @author coffezcat
 * @title: Boot1
 * @description: TODO
 * @date 2019/5/13 15:36
 */
public class Boot1 {
    public static void main(String[] args) {
        Observable<String> fs = new HelloWorldCommand("yw").observe();
        fs.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }
}
