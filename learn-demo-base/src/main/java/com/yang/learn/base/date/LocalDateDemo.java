package com.yang.learn.base.date;

import java.time.LocalDate;

/**
 * @author yangweia
 * @title
 * @date 2019年03月28日
 * @since v1.0.0
 */
public class LocalDateDemo {
    public static void main(String[] args) {
       LocalDate now =   LocalDate.now();
        LocalDate now1 = now.plusDays(1);
        System.out.println(now1);
    }
}
