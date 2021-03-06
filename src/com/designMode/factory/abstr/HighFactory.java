package com.designMode.factory.abstr;

import com.designMode.factory.simple.Car;

/**
 * @Author Stephen
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
