package com.iosocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Stephen
 * @date 2020/4/30 16:47
 */
public class SServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len;
        while((len = is.read(buff)) != -1){
            bos.write(buff,0,len);
        }

        System.out.println(bos.toString());
        bos.close();
        is.close();
        ss.close();
        socket.close();

    }
}
