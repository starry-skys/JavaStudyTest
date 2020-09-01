package com.abs;

/**
 *
 * @DATE 2019/4/12 17:34
 */
public abstract class AbsUser {
    public AbsUser() {
    }

    public static void main(String[] args) {
//        System.out.println(true && true);
//        System.out.println(true | false );
        System.out.println(testReturn());
    }

    static int testReturn(){
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return 0;
    }
}
