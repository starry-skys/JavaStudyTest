package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/3 15:27
 */
public class String2NumTest {

    public static void main(String[] args) {
//        String s = "91283472332";
//        System.out.println(Integer.parseInt(s));
        String str = "2147483646";
        System.out.println(myAtoi1(str));
    }

    private static int myAtoi(String str) {
        int res;
        str = str.trim();
        if(str == null || str.length() <= 0) return 0;
        char c = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        if(c == '-' || isNumber(c)){
            sb.append(c);
        }else if(c == '+'){
            sb.append(c);
        }else {
            return 0;
        }

        int x = 1;
        while (x < str.length() && isNumber(str.charAt(x))){
            sb.append(str.charAt(x));
            x ++;
        }

        try {
            res = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            if(sb.toString().equals("-") || sb.toString().equals("+")){
                return 0;
            }
            if(sb.toString().contains("-")){
                res = Integer.MIN_VALUE;
            }else {
                res = Integer.MAX_VALUE;
            }
        }
        return res;
    }

    private static boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    private static int myAtoi1(String str) {
        int res = 0;
        char[] chars = str.toCharArray();
        int n = chars.length;
        int x = 0;
        //如果前面是空格，则去掉
        while (x < n && chars[x] == ' '){
            x ++;
        }
        if(x == n){
            return 0;
        }
        //是否是负数的标志
        boolean flag = false;
        if(chars[x] == '-'){
            flag = true;
            x ++;
        }else if(chars[x] == '+'){
            x ++;
        }else if(!Character.isDigit(chars[x])){
            return 0;
        }


        while (x < n && Character.isDigit(chars[x])){
            int digit = chars[x] - '0';
            //如果超过integer最大值
            if(res > (Integer.MAX_VALUE - digit) /10){
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            x ++;
        }

        return flag ? -res : res;
    }
}
