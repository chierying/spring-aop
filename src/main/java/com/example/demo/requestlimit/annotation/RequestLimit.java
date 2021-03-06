package com.example.demo.requestlimit.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by v_zhangbing on 2017/7/2.
 * 限制访问
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RequestLimit {
    /**
     * 访问次数
     */
    int count() default Integer.MAX_VALUE;

    /**
     * 限定时间
     */
    long time() default 60000;
}
