package com.test.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author wanbei
 * @DATE 2019/4/10 15:53
 */
public class LogHandler implements InvocationHandler {

    private Object targetObj;

    public Object newProxyObject(Object targetObj){
        this.targetObj = targetObj;
        return Proxy.newProxyInstance(
                targetObj.getClass().getClassLoader(), //获取委托类的类加载器
                targetObj.getClass().getInterfaces(), //获取委托类实现的所有接口
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret;

        try {
            System.out.println("before method");
            ret = method.invoke(targetObj, args);
            System.out.println("after method");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("error");
            throw e;
        }

        return ret;
    }
}
