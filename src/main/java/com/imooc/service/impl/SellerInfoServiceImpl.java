package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cmy on 2018/10/3
 */
@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
