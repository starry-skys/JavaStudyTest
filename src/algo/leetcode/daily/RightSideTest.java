package algo.leetcode.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/22 21:32
 * 199. 二叉树的右视图
 */
public class RightSideTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.right = new TreeNode(5);
        node3.right = new TreeNode(4);

        System.out.println(rightSideView(root));

    }

    private static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if(i == size-1){
                    res.add(node.val);
                }
            }

        }

        return res;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }

    }



}
