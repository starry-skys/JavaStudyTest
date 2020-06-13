package com.iofile;

import java.io.*;

/**
 * @author Stephen
 * @date 2020/4/28 20:55
 */
public class ReaderTest {
    public static void main(String[] args) {
        //创建file对象
        File file = new File("hello2.txt"); //相对于module的，即JavaStudyTest根目录
        File file1 = new File("hello1.txt");
        //创建输入流，
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader(file);
            writer = new FileWriter(file1);
            BufferedReader br = new BufferedReader(reader);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            //读取
            char[] buff = new char[5];
            int len;
            while ((len = reader.read(buff)) != -1){
                writer.write(buff,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if(reader != null) {
                try {
                    writer.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
