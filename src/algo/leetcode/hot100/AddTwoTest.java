package algo.leetcode.hot100;

import org.junit.Test;

/**
 * @author Stephen
 * @date 2020/6/16 20:44
 */
public class AddTwoTest {

    @Test
    public void test(){
        ListNode node1 = new ListNode(3, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(2, node2);

        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(6, node4);
        ListNode node6 = new ListNode(5, node5);

        System.out.println(addTwoNumbers(node3, node6));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建一个空的头结点，方便做指针移动
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0; //表示进位
        //只要有任一个链表没有到尾部，就继续循环
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x , ListNode next) {
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
