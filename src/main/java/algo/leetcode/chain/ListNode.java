package algo.leetcode.chain;

public class ListNode {
    public int item;
    public ListNode next;

    public ListNode(int item) {
        this.item = item;
    }

    public ListNode(int item, ListNode next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while(current.next != null){
            sb.append(current.item).append("->");
            current = current.next;
        }
        sb.append(current.item).append("->").append("null");
        return sb.toString();
    }
}
