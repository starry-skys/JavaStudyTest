package com.string;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @Author wanbei
 * @DATE 2018/11/20 16:52
 */
public class Test2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","zs");
        String s = JSON.toJSONString(new Object[]{map});
        System.out.println(s);

        String s1 = "a";
    }
}
