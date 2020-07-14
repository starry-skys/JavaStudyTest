package algo.leetcode.chain;

public class Node<E> {
    E item;
    Node<E> next;

    Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    Node(E item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = this;
        while(current.next != null){
            sb.append(current.item).append("->");
            current = current.next;
        }
        sb.append(current.item).append("->").append("null");
        return sb.toString();
    }
}
