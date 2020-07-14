package algo.leetcode.chain;

/**
 * @author Stephen
 * @date 2020/4/15 14:38
 */
public class NodeTest {
    public static void main(String[] args) {
        Node node = new Node<Integer>(2,null);
        node = new Node(3,node);

        System.out.println(node);
    }
}
