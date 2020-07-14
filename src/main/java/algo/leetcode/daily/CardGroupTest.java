package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/3/27 18:00
 */
public class CardGroupTest {

    public static void main(String[] args) {
        int[] deck = {1,1,2,2,2,2};
        System.out.println(hasGroupsSizeX(deck));
    }

    //{1,2,3,4,4,3,2,1} {1,1,1,2,2,2,3,3}  {1,1,2,2,2,2}
    public static boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        if(n < 2) return false;

        int[] nums = new int[10000];
        for (int i : deck) {
            nums[i] ++;
        }

        //最大公约数，初始值设为0
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            x = gcd(x,c);
            if(x == 1){
                return false;
            }
        }

        return x >= 2;
    }

    private static int gcd(int x,int y){
        return y == 0 ? x : gcd(y, x % y);
    }

}
