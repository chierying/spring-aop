package com.example.demo.requestlimit.annotation;

import com.example.demo.requestlimit.RequestLimitConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by v_zhangbing on 2017/7/2.
 * 总开关, 启用访问限制功能.
 * 这个注解需要再SpringBoot主类上添加. 它引入了真正的配置类  @Import(RequestLimitConfiguration.class)
 */
@Retention(RetentionPolicy.RUNTIME)
@EnableAspectJAutoProxy
@Documented
@Import(RequestLimitConfiguration.class)
public @interface EnableRequestLimit {
}
