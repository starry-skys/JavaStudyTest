package com.thread.volatiles.enumholder;

/**
 *
 * @DATE 2018/11/15 17:26
 */
public class Singleton {
    private Singleton() {

    }

    private enum EnumHolder{
        INSTANCE;
        private Singleton instance;
        private EnumHolder(){
            this.instance = new Singleton();
        }
        private Singleton getSingleton(){
            return instance;
        }
        public String getName(){
            return null;
        }
    }

    public static Singleton getInstance(){

        return EnumHolder.INSTANCE.getSingleton();
    }

}
