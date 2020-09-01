package cn.mytest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Stephen
 * @date 2020/4/5 20:19
 */
public class PriorityTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };
        for (int i = 0; i < arrForHeap.length; i++) {
           queue1.offer(arrForHeap[i]);
        }
        while (!queue1.isEmpty()){
            System.out.print(queue1.poll() + " ");
        }

        System.out.println("");
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arrForHeap.length; i++) {
            queue2.offer(arrForHeap[i]);
        }
//        while (!queue2.isEmpty()){
//            System.out.print(queue2.poll() + " ");
//        }
        System.out.println(queue2.iterator().next());
    }

}

