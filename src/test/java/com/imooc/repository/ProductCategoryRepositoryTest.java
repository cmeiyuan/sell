package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by cmy on 2018/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        log.info("productCategory:" + productCategory);
    }

    @Test
    // 做完之后回滚
    // @Transactional
    public void saveTest() {
        // 直接new一个ProductCategory对象的话，会把创建时间也覆盖掉
        ProductCategory productCategory = repository.findOne(2);
        productCategory.setCategoryName("男生最爱2");
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }
}