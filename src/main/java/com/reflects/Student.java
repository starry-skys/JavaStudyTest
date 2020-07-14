package com.reflects;

/**
 * @author Stephen
 * @date 2020/4/12 11:46
 */
public class Student extends Person {
    public String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void study(String book){
        System.out.println(this.name + "学习" + book);
    }

    private void takeNap(int n){
        System.out.println(this.name + "小憩" + n +"分钟");
    }
}
