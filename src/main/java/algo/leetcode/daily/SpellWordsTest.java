package algo.leetcode.daily;

import java.util.ArrayList;

public class SpellWordsTest {


    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";

        System.out.println(chars.charAt(3) - 'a');
        System.out.println(countCharacters2(words, chars));
    }

    public static int countCharacters2(String[] words, String chars) {
        int[] charsCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charsCount[chars.charAt(i) - 'a']++;
        }

        int count = 0;
        for (String word : words) {
            boolean flag = true;
            int[] wordCount = new int[26];
            for (int i = 0; i < word.length(); i++) {
                wordCount[word.charAt(i) - 'a']++;
                if (wordCount[word.charAt(i) - 'a'] > charsCount[word.charAt(i) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += word.length();
            }
        }
        return count;
    }

    public static int countCharacters1(String[] words, String chars) {
        int count = 0;
        int[] charsCount = arrayCount(chars);
        for (String word : words) {
            int[] wordCount = arrayCount(word);
            boolean flag = true;
            for (int i = 0; i < wordCount.length; i++) {
                if (wordCount[i] > charsCount[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += word.length();
            }
        }
        return count;
    }

    //因为是26个小写英文字母，故计算出每个字母出现的次数
    public static int[] arrayCount(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            arr[c - 'a']++;
        }
        return arr;
    }

    //words = ["cat","bt","hat","tree"], chars = "atach"
    public static int countCharacters(String[] words, String chars) {

        int res = 0;
        String temp = chars;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int count = 0;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (temp.indexOf(ch) != -1) {
                    count++;
                    temp = temp.replaceFirst(String.valueOf(ch), "");
                } else {
                    break;
                }
            }
            temp = chars;
            //相等说明当前单词可以在字母表中找到
            if (count == word.length()) {
                res += word.length();
            }
        }

        return res;
    }
}


