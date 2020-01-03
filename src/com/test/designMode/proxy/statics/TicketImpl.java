package com.test.designMode.proxy.statics;

/**
 * @Author zwb
 * @DATE 2020/1/3 10:21
 */
public class TicketImpl implements ITicket {
    @Override
    public void purchase() {
        System.out.println("买票实现类");
    }
}
