package com.algo;

/**
 * @Author zwb
 * @DATE 2020/1/9 11:39
 * 计算1到100万之间的素数（只能被1和它本身整除的数）
 */
public class PrimeNumTest {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(2);
        for (int i = 3; i <= n; i = i+2) {
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int n) {
        boolean flag = true;
        int j = (int) Math.sqrt(n);
        for (int i = 3; i <= j; i++) {
            if( n%i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
