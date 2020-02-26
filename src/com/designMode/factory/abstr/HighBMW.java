package com.designMode.factory.abstr;

import com.designMode.factory.simple.Car;


/**
 * @Author zwb
 * @DATE 2019/12/23 16:07
 */
public class HighBMW implements Car {
    @Override
    public void getCar() {
        System.out.println("高配宝马车");
    }
}
