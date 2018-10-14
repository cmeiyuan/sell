package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cmy on 2018/10/3
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

}
