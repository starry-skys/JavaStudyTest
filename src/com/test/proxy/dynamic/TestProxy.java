package com.test.proxy.dynamic;

import com.test.proxy.UserManager;
import com.test.proxy.UserManagerImpl;

/**
 * @Author wanbei
 * @DATE 2019/4/10 16:07
 */
public class TestProxy {
    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();
        UserManager o = (UserManager)logHandler.newProxyObject(new UserManagerImpl());
        o.getName("ls");
        o.getId(2);
    }
}
