package com.test;

/**
 * @Author zwb
 * @DATE 2019/12/9 14:46
 */
public class TestCrit {
    public static void main(String[] args) {
        int c = 0;
        for (int i = 0; i < 100; i++) {
            int r = (int)(Math.random()*100);
            if(r<20){
                System.out.println(r);
                c++;
            }
        }
        System.out.println("命中"+c+"次");

//        Random random = new Random(10);
//        int i = random.nextInt(100);
//        System.out.println(i);

    }
}
