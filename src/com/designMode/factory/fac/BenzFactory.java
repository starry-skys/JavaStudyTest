package com.designMode.factory.fac;

import com.designMode.factory.simple.BenzCar;
import com.designMode.factory.simple.Car;

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
