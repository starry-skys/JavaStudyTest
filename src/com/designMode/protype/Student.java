package com.designMode.protype;

import java.io.*;

/**
 * @Author zwb
 * @DATE 2020/1/15 11:00
 */
public class Student implements Serializable {
    private int age;
    private String name;
    private transient Subject subject;

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


    //深克隆
    public Object deepClone() throws IOException, ClassNotFoundException{
        //把对象写入到流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从流中读取
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
