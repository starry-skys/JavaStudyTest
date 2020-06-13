package algo.leetcode.daily;

import algo.leetcode.chain.ListNode;

import java.util.Stack;

/**
 * @author Stephen
 * @date 2020/4/14 14:34
 * 445. 两数相加 II
 */
public class AddTwoNumberTest {

    public static void main(String[] args) {
        //(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode node4 = new ListNode(3, null);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(7, node2);

        ListNode node7 = new ListNode(4, null);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);

        addTwoNumbers(node1,node5);
    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while (l1 != null){
            stack1.push(l1.item);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2.item);
            l2 = l2.next;
        }

        ListNode head = null;
        int flag = 0; //是否进位的标志，1 进位
        while (stack1.size() > 0 || stack2.size() > 0 || flag > 0) {
            int sum = flag;
            sum += stack1.size() > 0 ? stack1.pop(): 0;
            sum += stack2.size() > 0 ? stack2.pop(): 0;

            ListNode newNode = new ListNode(sum%10);
            newNode.next = head;
            head = newNode;

            flag = sum / 10;
        }

        return head;
    }
}
