package com.example.demo.requestlimit;

import org.springframework.context.annotation.Bean;

/**
 * Created by v_zhangbing on 2017/7/2.
 */

public class RequestLimitConfiguration {

    @Bean
    public RequestLimitAspect requestLimitAspect() {
        return new RequestLimitAspect();
    }
}
