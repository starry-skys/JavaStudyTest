package com.test.designMode.factory.fac;

/**
 * @Author zwb
 * @DATE 2019/12/23 15:42
 */
public class FacTest {
    public static void main(String[] args) {
        BMWFactory bmwFactory = new BMWFactory();
        bmwFactory.produce().getCar();

        BenzFactory benzFactory = new BenzFactory();
        benzFactory.produce().getCar();
    }
}
