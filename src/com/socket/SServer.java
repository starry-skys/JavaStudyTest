package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @DATE 2019/11/11 16:39
 */
public class SServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = null;
            try {
                //创建一个ServerSocket在端口4700监听客户请求
                server = new ServerSocket(4700);
            } catch (Exception e) {
                e.printStackTrace();//出错，打印出错信息
            }
            Socket socket = null;
            try {
                //使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
                socket = server.accept();
            } catch (Exception e) {
                e.printStackTrace();//出错，打印出错信息
            }
            String line;
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            //由系统标准输入设备构造BufferedReader对象
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            //在标准输出上打印从客户端读入的字符串
            System.out.println("Client:" + is.readLine());
            //从标准输入读入一字符串
            line = sin.readLine();
            //如果该字符串为 "bye"，则停止循环
            while (!line.equals("bye")) {
                //向客户端输出该字符串
                os.println(line);
                //刷新输出流，使Client马上收到该字符串
                os.flush();
                //在系统标准输出上打印读入的字符串
                System.out.println("Server:" + line);
                //从Client读入一字符串，并打印到标准输出上
                System.out.println("Client:" + is.readLine());
                //从系统标准输入读入一字符串
                line = sin.readLine();
            }

            os.close(); //关闭Socket输出流
            is.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
            server.close(); //关闭ServerSocket
        } catch (Exception e) {
            e.printStackTrace();//出错，打印出错信息
        }
    }
}
