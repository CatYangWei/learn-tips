package com.yang.learn.base.datatype;

import java.math.BigDecimal;

/**
 * @author yangweia
 * @title
 * @date 2019年03月12日
 * @since v1.0.0
 */
public class BigdecimalBoot {
    public static void main(String[] args) {
        BigDecimal val = new BigDecimal(360);
        System.out.println(new BigDecimal(21.6).divide(val,4,BigDecimal.ROUND_HALF_DOWN));
    }
}
