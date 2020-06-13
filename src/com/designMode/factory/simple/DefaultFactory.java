package com.designMode.factory.simple;

/**
 * @Author Stephen
 * @DATE 2019/12/23 15:01
 */
public class DefaultFactory {
    public Car produce(String name){
        if(name.equals("benz")){
            return new BenzCar();
        }else if(name.equals("bmw")){
            return new BMWCar();
        }
        return null;
    }
}
