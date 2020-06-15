package com.recursive;

/**
 *
 * @DATE 2019/8/14 15:45
 */
public class InferTest {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        long res = infer(1000);
//        long time = System.currentTimeMillis() - start;
//        System.out.println(res);
//        System.out.println(time);
        StringBuffer sb = new StringBuffer("ab");
        sb.append((char)27);
        System.out.println(sb.toString());
    }

    //递推
    public static long infer(int n){
        if(n<=2){
            return n;
        }

        long f1 = 1;
        long f2 = 2;
        long sum = 0;
        for (int i = 3; i<= n ;i++){
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}
