package com.test.designMode.factory.fac;

import com.test.designMode.factory.simple.BenzCar;
import com.test.designMode.factory.simple.Car;

/**
 * @Author zwb
 * @DATE 2019/12/23 15:41
 */
public class BenzFactory implements IFactory {
    @Override
    public Car produce() {
        return new BenzCar();
    }
}
