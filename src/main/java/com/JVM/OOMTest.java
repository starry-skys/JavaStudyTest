package com.JVM;

import java.util.ArrayList;

/**
 * @author Stephen
 * @date 2020/6/25 19:27
 */
public class OOMTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024];
        ArrayList<OOMTest> list = new ArrayList<>();
        while(true){
            OOMTest test = new OOMTest();
            list.add(test);
        }

    }
}
