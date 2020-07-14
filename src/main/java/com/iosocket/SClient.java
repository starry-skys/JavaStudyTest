package com.iosocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Stephen
 * @date 2020/4/30 16:45
 */
public class SClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8899);
        OutputStream os = socket.getOutputStream();

        os.write("我是客户端".getBytes());
        os.close();
        socket.close();
    }
}
