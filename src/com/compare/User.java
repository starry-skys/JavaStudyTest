package com.compare;

/**
 * @Author zwb
 * @DATE 2020/1/6 15:10
 */
public class User implements Comparable<User>{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User() {

    }

    @Override
    public int compareTo(User o) {
        return this.getAge() - o.getAge();
    }
}
