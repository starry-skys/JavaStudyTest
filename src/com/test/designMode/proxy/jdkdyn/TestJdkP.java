package com.test.designMode.proxy.jdkdyn;

import com.test.designMode.proxy.statics.ITicket;
import com.test.designMode.proxy.statics.TicketImpl;

/**
 * @Author zwb
 * @DATE 2020/1/3 10:40
 */
public class TestJdkP {
    public static void main(String[] args) {
        TicketHandler handler = new TicketHandler();
        ITicket o = (ITicket)handler.newProxyObj(new TicketImpl());
        o.purchase();
    }
}
