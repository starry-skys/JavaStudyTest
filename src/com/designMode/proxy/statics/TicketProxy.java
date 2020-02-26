package com.designMode.proxy.statics;

/**
 * @Author zwb
 * @DATE 2020/1/3 10:22
 */
public class TicketProxy implements ITicket {
    TicketImpl ticketImpl;

    public TicketProxy(TicketImpl ticketImpl){
       this.ticketImpl = ticketImpl;
    }

    @Override
    public void purchase() {
        System.out.println("购买前");
        ticketImpl.purchase();
        System.out.println("购买后");
    }
}
