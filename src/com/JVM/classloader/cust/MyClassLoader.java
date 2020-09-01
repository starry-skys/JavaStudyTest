package com.JVM.classloader.cust;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author Stephen
 * @date 2020/6/13 14:31
 */
public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name,data,0,data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadByte(String name) throws Exception{
        name = name.replaceAll("\\.","/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("G://JavaStudyTest");
        String name = "CustTest";
        Class<?> clazz = classLoader.loadClass(name);
        Object obj = clazz.newInstance();
        Method hello = obj.getClass().getDeclaredMethod("hello");
        hello.invoke(obj,null);
    }
}
