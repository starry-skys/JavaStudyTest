package com.test.proxy;

/**
 * @Author wanbei
 * @DATE 2019/4/10 15:45
 */
public class UserManagerImpl implements UserManager {

    @Override
    public void getName(String name) {
        System.out.println("UserManagerImpl.getName:" + name);
    }

    @Override
    public void getId(int id) {
        System.out.println("UserManagerImpl.getId:" + id);
    }
}
