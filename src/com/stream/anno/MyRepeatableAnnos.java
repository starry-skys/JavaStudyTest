package com.stream.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author zwb
 * @DATE 2020/9/3 16:33
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatableAnnos {
    //需要是数组，且类型对应重复注解的类型
    MyRepeatableAnno[] value();
}
