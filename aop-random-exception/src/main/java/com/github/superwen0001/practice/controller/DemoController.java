package com.github.superwen0001.practice.controller;

import com.github.superwen0001.practice.exception.DemoException;
import com.github.superwen0001.practice.exception.RandomlyThrowsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wenshiliang on 2017/8/8.
 */
@RestController
public class DemoController {

    @GetMapping("t1")
    @RandomlyThrowsException(message = "测试随机异常", throwable = DemoException.class)
    public String t1() {
        return "t1";
    }
}
