package com.designMode.factory.fac;

import com.designMode.factory.simple.BMWCar;
import com.designMode.factory.simple.Car;

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
