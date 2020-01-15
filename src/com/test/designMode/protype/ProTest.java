package com.test.designMode.protype;

/**
 * @Author zwb
 * @DATE 2020/1/15 11:03
 */
public class ProTest {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student(18,"张三",new Subject("语文","这是语文书"));
        Student s2 = (Student)s1.clone();

        System.out.println(s1);
        System.out.println(s2);

        s2.setAge(20);
        s2.setName("李四");
        s2.getSubject().setName("数学").setContent("这是数学书");

        System.out.println("========");
        System.out.println(s1);
        System.out.println(s2);

    }
}
