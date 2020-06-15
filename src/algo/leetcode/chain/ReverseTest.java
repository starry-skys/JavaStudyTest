package algo.leetcode.chain;

public class ReverseTest {
    public static void main(String[] args) {
        Node node5 = new Node<Integer>(5, null);
        Node node4 = new Node<Integer>(4, node5);
        Node node3 = new Node<Integer>(3, node4);
        Node node2 = new Node<Integer>(2, node3);
        Node node1 = new Node<Integer>(1, node2);
        System.out.println(node1.toString());

        System.out.println(reverseList1(node1).toString());
    }

    public static Node<Integer> reverseList(Node<Integer> head){
        //避免空指针
        if(head == null || head.next == null) return head;
        Node<Integer> pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public static Node<Integer> reverseList1(Node<Integer> head){
        Node cur = head;
        Node pre = null;
        while(cur != null){
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}


