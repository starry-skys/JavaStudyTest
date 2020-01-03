package com.test.binary;

import java.math.BigDecimal;

/**
 * @Author zwb
 * @DATE 2019/12/6 11:41
 */
public class TestMove {
    public static void main(String[] args) {
        int a = -3;
        int x = 1;
        double r = a >>> x;
        long res = new BigDecimal(r).longValue();

        double rr = a + Math.pow(2,(32-x));
        long res2 = new BigDecimal(rr).longValue();

        System.out.println(res);
        System.out.println(res2);

    }


}
