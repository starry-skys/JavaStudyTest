package com.iofile.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Stephen
 * @date 2020/5/19 23:16
 */
public class TestBlock {
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));

        FileChannel inChannel = FileChannel.open(Paths.get("hello.txt"), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(inChannel.read(buffer) != -1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(9988));

        FileChannel outChannel = FileChannel.open(Paths.get("hello1.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        SocketChannel socketChannel = ssc.accept();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(socketChannel.read(buffer) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        socketChannel.close();
        outChannel.close();
    }
}
