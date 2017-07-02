package com.example.demo.requestlimit.Exceptions;

/**
 * Created by v_zhangbing on 2017/7/2.
 * Http请求限制异常
 */
public class RequestLimitException extends Exception {
    public RequestLimitException() {
        super("Http请求超出限定的次数");
    }

    public RequestLimitException(String message) {
        super(message);
    }
}
