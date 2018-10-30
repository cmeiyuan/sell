package com.imooc.controller;

import com.imooc.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cmy on 2018/10/19
 */
@RestController
@RequestMapping("/skill")
@Slf4j
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    /**
     * 查询秒杀商品
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable("productId") String productId) {
        return secKillService.querySecKillProductInfo(productId);
    }

    /**
     * 秒杀商品
     */
    @GetMapping("/order/{productId}")
    public String kill(@PathVariable("productId") String productId) {
        log.info("@skill request, productId:" + productId);
        secKillService.orderProductMockDiffUser(productId);
        return secKillService.querySecKillProductInfo(productId);
    }

}
