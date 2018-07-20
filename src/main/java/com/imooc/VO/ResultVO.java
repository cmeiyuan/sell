package com.imooc.VO;

import lombok.Data;

/**
 * Created by cmy on 2018/7/20
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
