package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * Created by cmy on 2018/10/3
 */
public interface SellerInfoService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
