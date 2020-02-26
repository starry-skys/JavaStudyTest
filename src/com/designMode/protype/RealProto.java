package com.designMode.protype;

/**
 * @Author zwb
 * @DATE 2019/12/20 17:20
 */
public class RealProto implements Cloneable {
    @Override
    public RealProto clone() throws CloneNotSupportedException {
        return (RealProto)super.clone();
    }

    public static void main(String[] args) throws Exception {
        RealProto r1 = new RealProto();
        RealProto r2 = r1.clone();
        System.out.println(r1 == r2);
        System.out.println(r1.getClass() == r2.getClass());
    }
}
