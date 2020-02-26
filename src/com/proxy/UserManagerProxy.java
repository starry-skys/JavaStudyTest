package com.proxy;

/**
 * @Author wanbei
 * @DATE 2019/4/10 15:46
 */
public class UserManagerProxy implements UserManager {

    UserManager userManager;

    public UserManagerProxy(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void getName(String name) {
        System.out.println("before getName");
        userManager.getName(name);
        System.out.println("after getName");
    }

    @Override
    public void getId(int id) {
        System.out.println("before getName");
        userManager.getId(id);
        System.out.println("after getName");
    }

    public static void main(String[] args) {
        UserManagerProxy proxy = new UserManagerProxy(new UserManagerImpl());
        proxy.getName("zhangsan");

    }
}
