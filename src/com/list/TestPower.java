package com.list;

/**
 * @Author wanbei
 * @DATE 2019/4/8 14:50
 */
public class TestPower {
    public static boolean isPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }

    public static void main(String[] args) {
        boolean b = isPowerOfTwo(3);
        System.out.println(b);
    }
}
