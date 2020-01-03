package com.test.designMode.factory.abstr;

import com.test.designMode.factory.simple.Car;

/**
 * @Author zwb
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