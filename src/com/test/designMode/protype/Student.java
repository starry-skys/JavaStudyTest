package com.test.designMode.protype;

/**
 * @Author zwb
 * @DATE 2020/1/15 11:00
 */
public class Student implements Cloneable {
    private int age;
    private String name;
    private Subject subject;

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student(int age, String name, Subject subject) {
        this.age = age;
        this.name = name;
        this.subject = subject;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
