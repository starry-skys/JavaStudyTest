package com.test.designMode.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author zwb
 * @DATE 2020/1/3 10:45
 */
public class TicketPurProx implements MethodInterceptor{

    Object target;

    public Object getProxy(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib前");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib后");
        return invoke;
    }
}
