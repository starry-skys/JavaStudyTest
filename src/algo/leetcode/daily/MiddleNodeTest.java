package algo.leetcode.daily;

import algo.leetcode.chain.ListNode;

/**
 * @author Stephen
 * @date 2020/3/23 10:00
 *  876. 链表的中间结点
 */
public class MiddleNodeTest {

    public static void main(String[] args) {
//        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(node1.toString());

        System.out.println(middleNode1(node1).toString());
    }

    //[1,2,3,4,5]
    public static ListNode middleNode(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int x = 0;
        while (head != null){
            arr[x++] = head;
            head = head.next;
        }
        return arr[x/2];
    }

    public static ListNode middleNode1(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while(cur.next != null){
            n ++;
            cur = cur.next;
        }

        int x = 0;
        while(head.next != null){
            if(x == (n + 1)/2) return head;
            x ++;
            head = head.next;
        }
        return head;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head,fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
