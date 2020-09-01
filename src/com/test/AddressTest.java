package com.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @DATE 2019/12/2 15:24
 */
public class AddressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.baidu.com");
            String hostName = address.getHostName();
            String hostAddress = address.getHostAddress();
            System.out.println(hostName);
            System.out.println(hostAddress);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostName() + "," + localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
