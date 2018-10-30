package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cmy on 2018/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    // private Logger log = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){
        log.info("test info");
        log.warn("test warn");
        log.error("test error");

        // .java -> .class

    }


}
