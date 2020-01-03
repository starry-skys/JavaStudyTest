package com.test.string;

import java.math.BigDecimal;

/**
 * @Author wanbei
 * @DATE 2018/12/26 14:07
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        String in = "20";
//        String result = toCent(in);
        String result = toYuan(in);
        System.out.println(result);
    }

    private static String toYuan(String in) {
        BigDecimal divide = new BigDecimal(in).divide(new BigDecimal(100));
        return divide.toPlainString();
    }

    private static String toCent(String in) {
        BigDecimal multiply = new BigDecimal(in).multiply(new BigDecimal(100));
        return String.valueOf(multiply);
    }
}
