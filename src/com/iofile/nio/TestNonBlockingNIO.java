package com.iofile.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Stephen
 * @date 2020/5/20 0:02
 */
public class TestNonBlockingNIO {
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));

        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            buffer.put((new Date().toString() + ":" + str).getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        socketChannel.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9988));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //遍历选择器上已经 准备就绪 的事件
        while(selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey sk = it.next();
                if(sk.isAcceptable()){
                    SocketChannel sChannel = serverSocketChannel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    SocketChannel socketChannel = (SocketChannel)sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len;
                    while((len = socketChannel.read(buffer)) > 0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //取消选择键
                it.remove();
            }
        }
    }
}
