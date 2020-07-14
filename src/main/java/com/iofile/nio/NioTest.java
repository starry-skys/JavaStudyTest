package com.iofile.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Stephen
 * @date 2020/5/18 17:00
 */
public class NioTest {
    @Test
    public void test1(){
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("--buffer--");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //放数据，position移动到字符串长度的位置
        buffer.put(str.getBytes());
        System.out.println("--put--");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        //切换到读模式，翻转位置。此时会把limit限定为字符串的长度，同时position归0
        buffer.flip();
        System.out.println("-------flip-------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        String res = new String(bytes,0,bytes.length);
        System.out.println("--结果--");
        System.out.println(res);

        //clear，清除缓冲区，所有参数还原，但是缓冲区数据不会被实际清除
        System.out.println("--clear--");
        buffer.clear();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        ByteBuffer.allocateDirect(1024);
    }

    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("hello.txt");
            fos = new FileOutputStream("hello1.txt");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(inChannel.read(buffer) != -1){
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outChannel.close();
                inChannel.close();
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //使用直接缓冲区（内存映射文件）
    public void test3() throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("hello.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("hello1.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dest = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dest);
        outMappedBuf.put(dest);

        outChannel.close();
        inChannel.close();
    }

    //分散读取，聚集写入
    @Test
    public void test4() throws Exception{
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        FileChannel inChannel = raf1.getChannel();

        //分配两个缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);

        //分散读取
        ByteBuffer[] buffers = {buffer1,buffer2};
        inChannel.read(buffers);
        for (ByteBuffer buffer : buffers) {
            buffer.flip();
        }

        RandomAccessFile raf2 = new RandomAccessFile("hello1.txt", "rw");
        FileChannel outChannel = raf2.getChannel();

        outChannel.write(buffers);

    }
}
