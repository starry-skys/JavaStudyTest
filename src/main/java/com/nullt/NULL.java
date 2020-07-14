package com.nullt;

/**
 *
 * @DATE 2018/11/6 14:24
 */
public class NULL {
    public static void haha(){
        System.out.println("haha");
    }

    public void hehe(){
        System.out.println("hehe");
    }

    public static void main(String[] args) {
        ((NULL)null).haha();
        ((NULL)null).hehe();

        String s1 = (String)null;
        System.out.println(s1 instanceof String);
    }
}
