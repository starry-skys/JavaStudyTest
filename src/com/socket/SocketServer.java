package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @DATE 2019/11/12 10:38
 */
public class SocketServer {
    //搭建服务器端
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5209);
        System.out.println("服务器启动成功");
        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while (true) {
            System.out.println("客户端说：" + in.readLine());
            String str = out.readLine();
            pw.println(str);
            pw.flush();
            System.out.println("服务器说：" + str);
        }
    }
}
