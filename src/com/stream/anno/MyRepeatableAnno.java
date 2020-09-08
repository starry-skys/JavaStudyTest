package com.stream.anno;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author zwb
 * @DATE 2020/9/3 16:31
 */
//需要添加 Repeatable 注解，并制定容器类 MyRepeatableAnnos
@Repeatable(MyRepeatableAnnos.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatableAnno {
    String value();
}
