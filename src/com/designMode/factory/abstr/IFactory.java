package com.designMode.factory.abstr;

import com.designMode.factory.simple.Car;

/**
 * @Author Stephen
 * @DATE 2019/12/23 16:02
 */
public interface IFactory {
    Car produceBMW();
    Car produceBenz();
}
