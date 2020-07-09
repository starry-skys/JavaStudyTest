package com.JVM;

public class HeapTest {
    public static void main(String[] args) {
        String str = "abcdefg";
        while(true){
            str += str;
        }
    }
}
