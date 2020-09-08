package com.stream.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface MyAnno {
    String value();
}
