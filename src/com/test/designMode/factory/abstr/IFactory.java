package com.test.designMode.factory.abstr;

import com.test.designMode.factory.simple.Car;

/**
 * @Author zwb
 * @DATE 2019/12/23 16:02
 */
public interface IFactory {
    Car produceBMW();
    Car produceBenz();
}
