package com.test.map;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @Author zwb
 * @DATE 2020/6/9 15:01
 */
public class TestHashMT {
    public static void main(String[] args) {
        Hashtable<String, String> table = new Hashtable<>();
        table.put("1","1");
        table.put("2","2");
        table.put("3","3");
//        Iterator<String> it = table.keySet().iterator();
//        while (it.hasNext()){
//            String key = it.next();
//            if("2".equals(key)){
//                table.remove(key);
//            }
//        }
//        System.out.println(table);

        Enumeration<String> keys = table.keys();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            if("2".equals(key)){
                table.remove(key);
            }
        }
        System.out.println(table);
    }
}
