package com.test.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author wanbei
 * @DATE 2019/4/11 10:43
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib开始");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib结束");
        return invoke;
    }

    public Object getCglibProxy(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //设置增强类的父类,即被代理类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //返回创建的代理类
        return enhancer.create();
    }
}
