package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cmy on 2018/8/31
 */
@RestController
@Slf4j
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.error("【首页】线程名称={}", Thread.currentThread().getName());
        return "线程ID:" + Thread.currentThread().getId() + "<br>" +
                "线程名称:" + Thread.currentThread().getName();
    }

    @PostMapping("/test")
    public String test(@RequestBody String body, MultipartFile file) {
        return body;
    }

}
