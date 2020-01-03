package com.test.designMode.factory.fac;

import com.test.designMode.factory.simple.BMWCar;
import com.test.designMode.factory.simple.Car;

/**
 * @Author zwb
 * @DATE 2019/12/23 15:39
 */
public class BMWFactory implements IFactory{
    @Override
    public Car produce() {
        return new BMWCar();
    }
}
