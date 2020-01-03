package com.test.designMode.adapter.interfaceadp;

/**
 * @Author zwb
 * @DATE 2020/1/3 11:51
 */
public class DefaultAdapter implements IDCOutput {
    @Override
    public int output5V() {
        return 0;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output20V() {
        return 0;
    }
}
