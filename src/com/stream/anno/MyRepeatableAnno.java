package com.stream.anno;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author zwb
 * @DATE 2020/9/3 16:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatableAnnos.class)
public @interface MyRepeatableAnno {
    String value();
}
