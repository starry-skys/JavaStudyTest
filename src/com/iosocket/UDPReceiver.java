package com.iosocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Stephen
 * @date 2020/4/30 17:29
 */
public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9000);

        byte[] buff = new byte[200];
        DatagramPacket packet = new DatagramPacket(buff,0, buff.length);

        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
