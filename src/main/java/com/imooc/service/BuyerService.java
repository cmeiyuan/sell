package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created by cmy on 2018/8/31
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);

}
