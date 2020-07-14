package algo.leetcode.daily.lfu;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Stephen
 * @date 2020/4/6 17:03
 */
public class LFUCache4 {

    public static void main(String[] args) {
        LFUCache4 cache = new LFUCache4(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 返回 1
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 去除 key 2
        // 返回 -1 (未找到key 2)
        System.out.println(cache.get(2));
        // 返回 3
        System.out.println(cache.get(3));
        cache.put(4, 4);    // 去除 key 1
        // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(1));
        // 返回 3
        System.out.println(cache.get(3));
        // 返回 4
        System.out.println(cache.get(4));
    }

    //缓存了所有元素的node
    Map<Integer,Node> cache;
    //优先队列
    Queue<Node> queue;
    //缓存cache 的容量
    int capacity;
    //当前缓存的元素个数
    int size;
    //全局自增
    int index = 0;

    //初始化
    public LFUCache4(int capacity){
        this.capacity = capacity;
        if(capacity > 0){
            queue = new PriorityQueue<>(capacity);
        }
        cache = new HashMap<>();
    }

    public int get(int key){
        Node node = cache.get(key);
        // node不存在，则返回 -1
        if(node == null) return -1;
        //每访问一次，频次和全局index都自增 1
        node.freq++;
        node.index = index++;
        // 每次都重新remove，再offer是为了让优先队列能够对当前Node重排序
        //不然的话，比较的 freq 和 index 就是不准确的
        queue.remove(node);
        queue.offer(node);
        return node.value;
    }

    public void put(int key, int value){
        //容量0，则直接返回
        if(capacity == 0) return;
        Node node = cache.get(key);
        //如果node存在，则更新它的value值
        if(node != null){
            node.value = value;
            node.freq++;
            node.index = index++;
            queue.remove(node);
            queue.offer(node);
        }else {
            //如果cache满了，则从优先队列中取出一个元素，这个元素一定是最小的
            if(size == capacity){
                cache.remove(queue.poll().key);
                //取出元素后，size减 1
                size--;
            }
            //否则，说明可以添加元素，于是创建一个新的node，添加到优先队列中
            Node newNode = new Node(key, value, index++);
            queue.offer(newNode);
            cache.put(key,newNode);
            //同时，size加 1
            size++;
        }
    }


    //必须实现 Comparable 接口才可用于排序
    private class Node implements Comparable<Node>{
        int key;
        int value;
        int freq = 1;
        int index;

        public Node(){

        }

        public Node(int key, int value, int index){
            this.key = key;
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            //优先比较频次，频次相同再比较index
            int minus = this.freq - o.freq;
            return minus == 0? this.index - o.index : minus;
        }
    }
}
