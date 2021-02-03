package com.bird.samples.demo.datasource;

import com.bird.lock.DistributedLockTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @author liuxx
 * @since 2021/1/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DatasourceTests {


    @Autowired
    private DataSource dataSource;

}
