package com.enums;

/**
 * @Author wanbei
 * @DATE 2018/11/16 14:44
 */
public enum  Color {
    RED("红色",1),BLUE("蓝色",2);
    private String name;
    private int index;
    Color(String name,int index){
        this.name = name;
        this.index = index;
    }

    public static String getName(int index){
        for (Color c : Color.values()) {
            if(c.getIndex() == index){
                return c.getName();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(Color.BLUE.toString());
        Color red = Color.valueOf("RED");
        System.out.println(red.getName()+red.getIndex());
    }
}

