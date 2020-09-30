package com.bird.samples.demo.service;

import com.baomidou.mybatisplus.core.toolkit.Sequence;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxx
 * @since 2020/9/28
 */
@SpringBootTest
public class SequenceTests {

    @Test
    public void SequenceTest() throws InterruptedException {
        Sequence sequence = new Sequence();

        int i = 0;
        while (i++<100){
            System.out.println(sequence.nextId());
            Thread.sleep(1000);
        }
    }
}
