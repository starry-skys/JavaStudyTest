package com.deliver;

/**
 * @Author zwb
 * @DATE 2020/1/8 10:51
 */
public class TestUser {
    public static void main(String[] args) {
        User user = new User(18, "zhangsan");
        System.out.println("修改对象前:"+user);
        changeUser(user);
        System.out.println("修改对象后:"+user);
    }

    private static void changeUser(User user) {
        user = new User();
        user.setAge(20);
        user.setName("lisi");
    }
}
