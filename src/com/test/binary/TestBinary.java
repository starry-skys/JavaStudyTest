package com.test.binary;

/**
 * @Author wanbei
 * @DATE 2019/12/3 15:49
 */
public class TestBinary {
    public static void main(String[] args) {
        // 0000 1110
        // 1111 0010
        System.out.println(-14>>>1);
        String bin = "01111111111111111111111111111001";
        double res = binToDec(bin);
        System.out.println(res);
    }

    public static double toDecimal(String bin){
        int len = bin.length();
        int res = 0;
        //index为-1说明没有小数
        for(int i = 0; i< len; i++){
            res += Math.pow(2,i) * Integer.parseInt(String.valueOf(bin.charAt(len-1-i)));
        }

        return res;
    }

    public static double binToDec(String bin){
        int index = bin.indexOf(".");
        int len = bin.length();
        double res = 0;
        //index为-1说明没有小数
        if(index == -1){
            for(int i = 0; i< len; i++){
                res += Math.pow(2,i) * Integer.parseInt(String.valueOf(bin.charAt(len-1-i)));
            }
        }else{
            //整数部分
            int partA = 0;
            for(int i = 0; i< index; i++){
                partA += Math.pow(2,i) * Integer.parseInt(String.valueOf(bin.charAt(index-1-i)));
            }
            //小数部分
            double partB = 0;
            for(int j = index + 1; j < len; j++){
                partB += Math.pow(2,index - j) * Integer.parseInt(String.valueOf(bin.charAt(j)));
            }
            res = partA + partB;
        }
        return res;
    }
}
