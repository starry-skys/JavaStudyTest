package com.iosocket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Stephen
 * @date 2020/4/30 20:55
 */
public class UConnTest {
    public static void main(String[] args) throws Exception {
        String link = "https://imgconvert.csdnimg.cn/aHR0cHM6Ly9ncmFwaC5iYWlkdS5jb20vcmVzb3VyY2UvMjIyMzMxNDQzNDIyYjE4ODdlZmRmMDE1ODcwMDg5MjkucG5n?x-oss-process=image/format,png";
        URL url = new URL(link);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("pic.png"));
        byte[] buff = new byte[1024];
        int len;
        while ((len = is.read(buff)) != -1){
            fos.write(buff,0,len);
        }

        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
