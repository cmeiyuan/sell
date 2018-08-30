package com.imooc.VO;

import lombok.Data;

/**
 * Created by cmy on 2018/7/20
 */
@Data
public class ResultVO<T> {

    private Integer code;

    // 避免msg反回为null
    private String msg = "";

    private T data;

}
