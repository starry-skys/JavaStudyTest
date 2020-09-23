package com.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author zwb
 * @DATE 2020/9/23 09:37
 */
public class CgTest {

    public static Object getCglibProxy(Object object){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MethodInterceptor(){
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before");
                Object ret = method.invoke(object,args);
                System.out.println("after");
                return ret;
            }
        });

        return enhancer.create();
    }

    public static Object getCglibProxy1(Object object){
        return Enhancer.create(object.getClass(), (MethodInterceptor) (obj, method, args, proxy) -> {
            System.out.println("before");
            Object ret = method.invoke(object,args);
            System.out.println("after");
            return ret;
        });
    }
}
