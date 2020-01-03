package com.test.list;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @Author wanbei
 * @DATE 2019/4/25 10:13
 */
public class TestLinkedMap {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("name","zs");
        map.put("age","12");
        map.put("sex","男");

        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(map.get(key));
        }
        System.out.println(map);
    }
}
