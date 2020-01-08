package com.test.deliver;

/**
 * @Author zwb
 * @DATE 2020/1/7 11:46
 */
public class TestChange {
    static Integer a = 3;

    public static void main(String[] args) {



        Integer b = 5;

        System.out.format("a=%d,b=%d\n",a,b);

        swamp(a, b);

        System.out.format("a=%d,b=%d\n",a,b);

    }

    public static void swamp(Integer x, Integer y){

        Integer t = 5;
        x = t;
        System.out.println(x == t);
        System.out.println(a == x);
    }
}
