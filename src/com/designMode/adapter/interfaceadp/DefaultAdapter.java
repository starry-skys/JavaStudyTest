package com.designMode.adapter.interfaceadp;

/**
 * @Author Stephen
 * @DATE 2020/1/3 11:51
 */
public abstract class DefaultAdapter implements IDCOutput {
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
