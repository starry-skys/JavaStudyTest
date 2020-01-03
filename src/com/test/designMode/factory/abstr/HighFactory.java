package com.test.designMode.factory.abstr;

import com.test.designMode.factory.simple.Car;

/**
 * @Author zwb
 * @DATE 2019/12/23 16:04
 */
public class HighFactory implements IFactory {
    @Override
    public Car produceBMW() {
        return new HighBMW();
    }

    @Override
    public Car produceBenz() {
        return new HighBenz();
    }
}
