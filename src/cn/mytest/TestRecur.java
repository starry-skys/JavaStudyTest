package cn.mytest;

/**
 * @Author zwb
 * @DATE 2020/7/7 10:05
 */
public class TestRecur {
    public static void main(String[] args) {
        printOut(67852);
    }
    public static void printOut(int n) {
        if (n >= 10){
            printOut(n / 10);
        }
        System.out.print(n % 10);
    }
}
