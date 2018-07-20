package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by cmy on 2018/7/20
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    // 查询所有上架商品
    List<ProductInfo> findUpAll();

    List<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    // 减库存

}
