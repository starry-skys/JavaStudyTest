package com.test.designMode.proxy.statics;

/**
 * @Author zwb
 * @DATE 2020/1/3 10:26
 */
public class StaPTest {
    public static void main(String[] args) {
        TicketProxy proxy = new TicketProxy(new TicketImpl());
        proxy.purchase();
    }

}
