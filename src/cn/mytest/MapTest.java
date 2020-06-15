package cn.mytest;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Stephen
 * @date 2020/4/7 16:27
 */
public class MapTest {

    public static void main(String[] args) {
//        Object o = new Object();
//        int hash = o.hashCode();
//        System.out.println(hash);
//        System.out.println(Integer.toBinaryString(hash));
//        hash = hash ^ (hash >>> 16);
//        System.out.println(Integer.toBinaryString(hash));

//        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
//        hashtable.put(1,1);
//        hashtable.put(2,2);
//        hashtable.put(3,3);
//        Iterator<Integer> it = hashtable.keySet().iterator();
//        while(it.hasNext()){
//            Integer key = it.next();
//            if(key == 2){
//                hashtable.remove(key);
//            }
//            System.out.println(key + ":" + hashtable.get(key));
//
//        }


        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,1);
        concurrentHashMap.put(2,2);
        concurrentHashMap.put(3,3);
        Iterator<Integer> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()){
            Integer key = it.next();
            if(key == 2) concurrentHashMap.put(4,4);
            System.out.println(key + ":" + concurrentHashMap.get(key));
        }

//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        hashMap.put(1,1);
//        hashMap.put(2,2);
//        hashMap.put(3,3);
//        Iterator<Integer> iterator = hashMap.keySet().iterator();
//        while (iterator.hasNext()){
//            Integer key = iterator.next();
//            if(key == 2) hashMap.put(key,22);
//            System.out.println(key + ":" + hashMap.get(key));
//        }


    }

    private static class Cell {
        int value;

        private Cell (int v){
            value = v;
        }
    }

}
