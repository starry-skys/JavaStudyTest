package com.iosocket;

import java.io.IOException;
import java.net.*;

/**
 * @author Stephen
 * @date 2020/4/30 17:24
 */
public class UDPSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String content = "我是UDP发送方";
        byte[] data = content.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, 9000);

        socket.send(packet);

        socket.close();

    }
}
