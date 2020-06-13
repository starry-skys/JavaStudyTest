package com.designMode.proxy.statics;

import java.lang.reflect.Method;

/**
 * @Author Stephen
 * @DATE 2020/1/3 10:26
 */
public class StaPTest {
    public static void main(String[] args) {
        TicketProxy proxy = new TicketProxy(new TicketImpl());
        proxy.purchase();

        Class<TicketImpl> clazz = TicketImpl.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
            Method[] declaredMethods = anInterface.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println(method.getName());
            }
        }


    }

}
