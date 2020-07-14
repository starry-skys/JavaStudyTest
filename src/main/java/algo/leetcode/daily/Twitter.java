package algo.leetcode.daily;

import java.util.*;

/**
 * @author Stephen
 * @date 2020/4/13 15:35
 * 355. 设计推特
 */
public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 4);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        twitter.getNewsFeed(1);

        // 用户1关注了用户2.
//        twitter.follow(1, 2);
        twitter.postTweet(2, 5);
//
//        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        twitter.getNewsFeed(1);
//
//        // 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        twitter.unfollow(1,2);
        twitter.getNewsFeed(1);

    }


    //某用户的关注列表
    HashMap<Integer, Set<Integer>> followMap;
    //每个用户对应一条单链表
    Map<Integer,Node> tweetMap;
    //全局的时间戳
    static int timestamp = 0;
    //优先队列
    PriorityQueue<Node> heap;

    private class Node {

        private int id; //推文id
        private int timestamp; //时间戳
        private Node next;

        public Node (int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }

    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.timestamp - o1.timestamp;
            }
        });
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        timestamp ++;
        if(tweetMap.containsKey(userId)){
            Node head = tweetMap.get(userId);
            Node newHead = new Node(tweetId,timestamp);
            newHead.next = head;
            tweetMap.put(userId,newHead);
        }else{
            tweetMap.put(userId,new Node(tweetId,timestamp));
        }
        System.out.println("用户" + userId + "发布了推文,id:" + tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        //每次使用前先清空
        heap.clear();

        //把自己的推文加进来
        if(tweetMap.containsKey(userId)){
            heap.offer(tweetMap.get(userId));
        }

        //关注用户列表
        Set<Integer> followSet = followMap.get(userId);
        if(followSet != null && followSet.size() > 0){
            for (Integer followId : followSet) {
                Node node = tweetMap.get(followId);
                if(node != null){
                    heap.offer(node);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        int count = 0;
        while (!heap.isEmpty() && count < 10){
            //此时所有单链表中的最大值
            Node node = heap.poll();
            res.add(node.id);

            //把当前链表的下一个节点加入到堆中，继续下次循环比较
            if(node.next != null){
                heap.offer(node.next);
            }
            count ++;
        }
        System.out.println(res);
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        //不能自己关注自己
        if(followeeId == followerId) return;

        Set<Integer> set = followMap.get(followerId);
        if (set == null) {
            set = new HashSet<>();
            followMap.put(followerId, set);
        }
        set.add(followeeId);
        System.out.println("用户" + followerId + "关注了用户" + followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId == followerId) return;
        Set<Integer> set = followMap.get(followerId);
        if (set == null) {
            return;
        }
        set.remove(followeeId);
        System.out.println("用户" + followerId + "取消关注了用户" + followeeId);
    }
}