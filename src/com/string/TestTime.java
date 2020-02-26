package com.string;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author wanbei
 * @DATE 2018/12/27 09:34
 */
public class TestTime {
    public static void main(String[] args) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long l = System.currentTimeMillis();
        long time = new Date().getTime();
        System.out.println(timeInMillis);
        System.out.println(l);
        System.out.println(time);
        String[] strings = new String[3];

    }
}
