package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cmy on 2018/7/20
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVO list() {
        List<ProductInfo> list = productService.findUpAll();
        return ResultVOUtil.success(list);
    }

}
