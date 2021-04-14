package com.bird.samples.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.bird.samples.model.DemoDO;
import com.bird.samples.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author liuxx
 * @since 2020/9/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class BlockAttackInterceptorTests {

    @Autowired
    private DemoService demoService;

    @Test
    void updateTests() {
        checkEx(() -> demoService.lambdaUpdate().set(DemoDO::getName, "update").update(), "full update");

        QueryWrapper<DemoDO> wrapper = new QueryWrapper<>();
        checkEx(() -> demoService.delete(wrapper), "full delete");
        checkEx(() -> demoService.deleteAll(), "full delete");
    }

    void checkEx(Runnable action, String as) {
        Exception e = null;
        try {
            action.run();
        } catch (Exception x) {
            e = x;
        }
        assertThat(e).as(as).isNotNull();
        assertThat(e).as(as).isInstanceOf(MyBatisSystemException.class);
    }

    private final BlockAttackInnerInterceptor interceptor = new BlockAttackInnerInterceptor();

    @Test
    void update() {
        checkEx("update user set name = null where 0='0'", "1=1");

//        checkEx("update user set name = null", "null where");
//        checkEx("update user set name = null where 1=1", "1=1");
//        checkEx("update user set name = null where 1<>2", "1<>2");
//        checkEx("update user set name = null where 1!=2", "1!=2");
//        checkEx("update user set name = null where 1=1 and 2=2", "1=1 and 2=2");
//        checkEx("update user set name = null where 1=1 and 2=3 or 1=1", "1=1 and 2=3 or 1=1");
//        checkEx("update user set name = null where 1=1 and (2=2)", "1=1 and (2=2)");
//        checkEx("update user set name = null where (1=1 and 2=2)", "(1=1 and 2=2)");
//        checkEx("update user set name = null where (1=1 and (2=2 or 3=3))", "(1=1 and 2=2)");
//
//        checkEx("update user set name = null where (1=1 and (2=3 or 3=3))", "(1=1 and (2=3 or 3=3))");
//
//        checkNotEx("update user set name = null where 1=?", "1=?");
    }

    void checkEx(String sql, String as) {
        Exception e = null;
        try {
            interceptor.parserSingle(sql, null);
        } catch (Exception x) {
            e = x;
        }
        assertThat(e).as(as).isNotNull();
        assertThat(e).as(as).isInstanceOf(MybatisPlusException.class);
    }

    void checkNotEx(String sql, String as) {
        Exception e = null;
        try {
            interceptor.parserSingle(sql, null);
        } catch (Exception x) {
            e = x;
        }
        assertThat(e).as(as).isNull();
    }
}
