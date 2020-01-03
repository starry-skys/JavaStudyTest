package com.test.designMode.factory.abstr;

/**
 * @Author zwb
 * @DATE 2019/12/23 16:10
 */
public class AbsTest {
    public static void main(String[] args) {
        HighFactory highFactory = new HighFactory();
        highFactory.produceBMW().getCar();
        highFactory.produceBenz().getCar();

        LowFactory lowFactory = new LowFactory();
        lowFactory.produceBMW().getCar();
        lowFactory.produceBenz().getCar();
    }
}
