package com.test.recursive;

/**
 * @Author wanbei
 * @DATE 2019/8/13 14:35
 */
public class NodeTest {
    static final class Node{
        int data;
        Node next;

        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    static String getNodeList(Node node){
        String res = "";
        while(node!=null){
            res += node.data + ">";
            node = node.next;
        }
        res += "null";
        return res;
    }

    //单链表反转
    public static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newList = reverseList(head.next);
        Node t1 = head.next;
        //链表指向反转一下
        t1.next = head;
        head.next = null;
        return newList;
    }

    //K个为一组逆序
    public static Node reverseKGroup(Node head,int k){
        Node temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }

        if(temp == null){
            return head;
        }

        Node t2 = temp.next; //第二组的头
        temp.next = null;
        //当前组反转
        Node newHead = reverseList(head);
        //之后的节点分组逆序
        Node newTemp = reverseKGroup(t2,k);
        head.next = newTemp;

        return newHead;
    }

    public static void main(String[] args) {
        Node node8 = new Node(8, null);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        System.out.println(getNodeList(node1));
        //单反转
//        Node node = reverseList(node1);
//        System.out.println(getNodeList(node));
        //分组反转
        Node reverK = reverseKGroup(node1,3);
        System.out.println(getNodeList(reverK));
    }
}
