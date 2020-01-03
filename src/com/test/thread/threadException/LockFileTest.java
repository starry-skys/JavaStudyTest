package com.test.thread.threadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/8 16:07
 */
public class LockFileTest {
    private static final String LOCK_PATH = "/Users/sunfund/Desktop/";
    private static final String LOCK_FILE = ".lock";
    private static final String PERMISSIONS = "rw-------";

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("received kill signal");
            getLockFile().toFile().delete();
        }));

        checkRunning(); //检查是否存在.lock文件

        for (; ; ) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("program is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if(path.toFile().exists()){
            throw new RuntimeException("program already running.");
        }
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        Files.createFile(path,attr);

    }

    private static Path getLockFile() {
        return Paths.get(LOCK_PATH,LOCK_FILE);
    }

}
