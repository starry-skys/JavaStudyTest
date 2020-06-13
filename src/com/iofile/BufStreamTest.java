package com.iofile;

import java.io.*;
import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/28 21:58
 */
public class BufStreamTest {
    public static void main(String[] args) {

        String str = "ab";
        System.out.println(Arrays.toString(str.toCharArray()));
        File srcPath = new File("route.png");
        File destPath = new File("route1.png");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(srcPath);
            FileOutputStream fos = new FileOutputStream(destPath);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buff = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1){
                bos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
