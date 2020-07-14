package com.iofile.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Stephen
 * @date 2020/5/20 11:15
 */
public class TestUDP {

    @Test
    public void client() throws IOException {
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            buf.put((new Date().toString() + ":" + str).getBytes());
            buf.flip();
            dc.send(buf,new InetSocketAddress("127.0.0.1",9988));
            buf.clear();
        }

        dc.close();
    }

    @Test
    public void server() throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        dc.bind(new InetSocketAddress(9988));

        Selector selector = Selector.open();
        dc.register(selector, SelectionKey.OP_READ);

        while(selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while(it.hasNext()){
                SelectionKey sk = it.next();
                if(sk.isReadable()){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    dc.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                    buffer.clear();
                }
                it.remove();
            }
        }
    }
}
