package com.test.map;

import java.util.Collections;
import java.util.HashMap;

/**
 * @Author
 * @DATE 2020/6/9 15:01
 */
public class TestHashMT {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        Collections.synchronizedMap(map);

    }

}
