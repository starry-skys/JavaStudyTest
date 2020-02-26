package com.seed;

import java.util.Random;

/**
 * @Author wanbei
 * @DATE 2019/10/20 10:15
 */
public class TestSeed {
    public static void main(String[] args) {
        Random random = new Random(10);
        String s = "";
        for (int i = 0; i < 10; i++) {
            int next = random.nextInt(10);
            s += next + ",";
        }
        System.out.println(s);

    }
}
