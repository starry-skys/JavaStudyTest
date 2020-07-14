package algo.leetcode.daily;

import java.util.PriorityQueue;

/**
 * @author Stephen
 * @date 2020/4/26 21:33
 * 23. 合并K个排序链表
 */
public class MergeKListTest {

    public static void main(String[] args) {
        //  1->4->5,
        //  1->3->4,
        //  2->6
        ListNode node3 = new ListNode(5);
        ListNode node2 = new ListNode(4,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode node6 = new ListNode(4);
        ListNode node5 = new ListNode(3,node6);
        ListNode node4 = new ListNode(1,node5);

        ListNode node8 = new ListNode(6);
        ListNode node7 = new ListNode(2,node8);

        ListNode[] lists = {node1,node4,node7};
        System.out.println(mergeKLists(lists));
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        //优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode list : lists) {
            if(list != null){
                queue.offer(list);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = minNode;
            if(minNode.next != null){
                queue.offer(minNode.next);
            }
        }
        return dummyNode.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while(current.next != null){
                sb.append(current.val).append("->");
                current = current.next;
            }
            sb.append(current.val).append("->").append("null");
            return sb.toString();
        }
    }
}
