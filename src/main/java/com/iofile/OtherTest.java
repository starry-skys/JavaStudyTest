package com.iofile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Stephen
 * @date 2020/4/28 23:47
 */
public class OtherTest {
    public static void main(String[] args) {
        //转换流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String data;
            while (true){
                data = br.readLine();
                if("e".equalsIgnoreCase(data))
                    break;
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
