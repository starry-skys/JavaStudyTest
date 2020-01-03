package com.test.binary;

/**
 * @Author zwb
 * @DATE 2019/12/6 16:40
 */
public class TestAdd {
    public static void main(String[] args) {
        String a = "11111111";
        String b = "00000001";
        String res = add(a, b);
        System.out.println(res);
    }

    public static String add(String a,String b){
        StringBuffer sb = new StringBuffer();

        int x = 0;
        int y = 0;
        int pre = 0; //进位
        int sum = 0;

        //把两个参数的长度填充为一样的
        while(a.length() != b.length()){
            if(a.length() > b.length()){
                b += "0" + b;
            }else{
                a += "0" + a;
            }
        }

        for (int i = a.length()-1; i >= 0 ; i--) {
            x = a.charAt(i) - '0';
            y = b.charAt(i) - '0';
            sum = x + y + pre;
            if(sum >=2){
                sb.append(sum -2);
                pre = 1;
            }else{
                sb.append(sum);
                pre = 0;
            }
        }

//        if(pre == 1){
//            sb.append("1");
//        }
        return sb.reverse().toString();
    }
}
