package com.classLoad.jdkInternal;

/**
 * @Author wanbei
 * @DATE 2018/11/13 15:36
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        //1.根类加载器
        System.out.println(System.getProperty("sun.boot.class.path"));

        //2.扩展类加载器
        System.out.println(System.getProperty("java.ext.dirs"));

        //3.系统类加载器
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(ClassLoaderTest.class.getClassLoader());

    }
}
