package algo.leetcode.daily;

// 409. 最长回文串
public class PalindromeTest {

    public static void main(String[] args) {
        String str = "abcccdd";
        System.out.println(longestPalindrome(str));
    }

    //abccccdd
    public static int longestPalindrome(String s) {
        int[] arr = new int[58];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'A'] ++;
        }
        int odd = 0; //统计出现奇数次数的字母个数
        for (int c : arr) {
            // c&1==1 效果同 c%2==1
            if((c & 1) == 1){
                odd ++;
            }
        }
        return odd == 0? len : len - odd + 1;
    }

    public static int longestPalindrome1(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }
}
