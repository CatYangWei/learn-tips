package com.yang.learn.base.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yangweia
 * @title
 * @date 2019年03月12日
 * @since v1.0.0
 */
public class Boot {
    public static void main(String[] args) throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date  _1_30= simpleDateFormat.parse("2019-01-17");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(_1_30);
        calendar.add(Calendar.MONTH,1);

        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
