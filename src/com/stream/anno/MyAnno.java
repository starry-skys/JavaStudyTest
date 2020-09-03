package com.stream.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE_PARAMETER,TYPE,PARAMETER})
public @interface MyAnno {
    String value();
}
