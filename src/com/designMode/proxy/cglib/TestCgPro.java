package com.designMode.proxy.cglib;

/**
 * @Author Stephen
 * @DATE 2020/1/3 10:50
 */
public class TestCgPro {
    public static void main(String[] args) {
        TicketPurProx prox = new TicketPurProx();
        TicketCls tick = (TicketCls)prox.getProxy(new TicketCls());
        tick.getTicket();

    }
}
