package com.designMode.factory.abstr;

import com.designMode.factory.simple.Car;

/**
 * @Author Stephen
 * @DATE 2019/12/23 16:09
 */
public class LowFactory implements IFactory {
    @Override
    public Car produceBMW() {
        return new LowBMW();
    }

    @Override
    public Car produceBenz() {
        return new LowBenz();
    }
}
