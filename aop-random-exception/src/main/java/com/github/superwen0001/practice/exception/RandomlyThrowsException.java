package com.github.superwen0001.practice.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wenshiliang on 2017/8/8.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RandomlyThrowsException {
    String message() default "";

    Class<? extends Throwable>[] throwable() default RuntimeException.class;

}
