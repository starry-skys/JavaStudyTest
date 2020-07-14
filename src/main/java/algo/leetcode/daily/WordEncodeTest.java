package algo.leetcode.daily;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Stephen
 * @date 2020/3/28 14:03
 * 820. 单词的压缩编码
 */
public class WordEncodeTest {

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding1(words));
    }

    //words = ["time", "me", "bell"]
    public static int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j < word.length(); j++) {
                set.remove(word.substring(j));
            }
        }

        int res = 0;
        for (String s : set) {
            res += s.length() + 1;
        }
        return res;
    }

    //字母倒叙排序，加入字典树，判断当前节点count是否为0，即叶子结点
    public static int minimumLengthEncoding1(String[] words) {
        //作为根节点
        TrieNode root = new TrieNode();

        HashMap<TrieNode, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                cur = cur.getNode(word.charAt(j));
            }
            //记录下当前遍历到的最后一个node，和单词在数组中的下标i，以便后续统计单词长度
            map.put(cur,i);
        }

        int res = 0;
        for (TrieNode node : map.keySet()) {
            //count等于0，说明当前节点没有子节点，也就是说当前节点是叶子节点
            if(node.count == 0){
                int index = map.get(node);
                res += words[index].length() + 1;
            }
        }
        return res;
    }

}


class TrieNode {
    TrieNode[] children;
    int count;

    public TrieNode(){
        children = new TrieNode[26];
        count = 0;
    }

    //判断当前节点的子节点是否为空，为空则创建一个新的子节点，并把当前节点count加1
    public TrieNode getNode(char c){
        if(children[c-'a'] == null){
            children[c-'a'] = new TrieNode();
            count ++;
        }
        return children[c-'a'];
    }

}