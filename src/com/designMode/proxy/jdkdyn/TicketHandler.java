package com.designMode.proxy.jdkdyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Stephen
 * @DATE 2020/1/3 10:27
 */
public class TicketHandler implements InvocationHandler{
    public Object targetObject;

    public Object newProxyObj(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前");
        Object invoke = method.invoke(targetObject, args);
        System.out.println("执行方法后");
        return invoke;
    }
}
