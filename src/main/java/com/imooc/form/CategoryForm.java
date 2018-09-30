package com.imooc.form;

import lombok.Data;

/**
 * Created by cmy on 2018/9/5
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
