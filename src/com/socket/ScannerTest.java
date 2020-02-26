package com.socket;

import java.util.Scanner;

/**
 * @Author wanbei
 * @DATE 2019/11/12 10:18
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = in.nextLine();//读取换行符为间隔的
        System.out.println("Hello "+name+".");
        System.out.println("What's your name?");
        System.out.println("Hello "+in.next()+in.next()+".");   //读取空格为间隔的
        System.out.println("How old are you?");
        int age = in.nextInt(); //读取数字
        System.out.println("Are you  "+age+"?");
    }
}
