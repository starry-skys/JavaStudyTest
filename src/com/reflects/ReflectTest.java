package com.reflects;

import java.lang.reflect.Field;

/**
 * @author Stephen
 * @date 2020/4/12 11:44
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Student stu = new Student();
        stu.setAge(12);
        stu.setName("张三");

        Class<? extends Student> stuClass = stu.getClass();
        Field[] fields = stuClass.getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            System.out.println(field.get(stu));
//        }
        Field name = stuClass.getField("name");
        name.set(stu,"李四");
        Field age = stuClass.getDeclaredField("age");
        age.setAccessible(true);
        age.setInt(stu,13);
        System.out.println(stu);

//        Constructor<?> constructor = stuClass.getConstructor(String.class,int.class);
//        Object o = constructor.newInstance("李四",12);
//        System.out.println(o);

//        Method study = stuClass.getMethod("study", String.class);
//        study.invoke(stu,"英语");
//
//        Method takeNap = stuClass.getDeclaredMethod("takeNap", int.class);
//        takeNap.setAccessible(true);
//        takeNap.invoke(stu,5);


    }
}
