package com.example.demo.controller;

import com.example.demo.requestlimit.annotation.RequestLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by v_zhangbing on 2017/7/2.
 */
@Controller
@Slf4j
public class UserController {

    @RequestLimit(count = 3, time = 10000)
    @ResponseBody
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable String id, HttpServletRequest request) {
        log.info("访问controller");
        return "user with id:" + id;
    }

}
