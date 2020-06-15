package algo.leetcode.daily.lfu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/5 17:29
 * 460. LFU缓存
 * 一条双向链表实现，freq访问次数小的在左，大的在右，相等的话，最久未使用的在左，最近使用的在右。
 * 即访问次数最小，且最久访问的在最左边
 */
public class LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
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

    private Map<Integer,Node> cache;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        /**
         * 初始化头结点和尾结点，并作为哨兵节点
         */
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        node.freq++;
        moveToPostion(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        Node node = cache.get(key);
        if(node != null){
            node.value = value;
            node.freq++;
            moveToPostion(node);
        }else{
            //如果元素满了
            if(size == capacity){
                //直接移除最前面的元素，因为这个节点就是频次最小，且最久未访问的节点
                cache.remove(head.next.key);
                removeNode(head.next);
                size--;
            }
            Node newNode = new Node(key, value);
            //把新元素添加进来
            addNode(newNode);
            cache.put(key,newNode);
            size++;
        }
    }

    //只要当前 node 的频次大于等于它后边的节点，就一直向后找，
    // 直到找到第一个比当前node频次大的节点，或者tail节点，然后插入到它前面
    private void moveToPostion(Node node){
        Node nextNode = node.next;
        //先把当前元素删除
        removeNode(node);
        //遍历到符合要求的节点
        while (node.freq >= nextNode.freq && nextNode != tail){
            nextNode = nextNode.next;
        }
        //把当前元素插入到nextNode前面
        node.pre = nextNode.pre;
        node.next = nextNode;
        nextNode.pre.next = node;
        nextNode.pre = node;

    }

    //添加元素（头插法），并移动到合适的位置
    private void addNode(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        moveToPostion(node);
    }

    //移除元素
    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    class Node {
        int key;
        int value;
        int freq = 1;
        //当前节点的前一个节点
        Node pre;
        //当前节点的后一个节点
        Node next;

        public Node(){

        }

        public Node(int key ,int value){
            this.key = key;
            this.value = value;
        }
    }
}

