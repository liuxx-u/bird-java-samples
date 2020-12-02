package com.bird.samples.service;

import com.bird.eventbus.handler.EventHandler;
import com.bird.samples.mapper.DemoMapper;
import com.bird.samples.model.DemoDO;
import com.bird.samples.pojo.TestArg;
import com.bird.service.common.service.AbstractStringService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author liuxx
 * @since 2020/9/22
 */
@Service
public class DemoService extends AbstractStringService<DemoMapper, DemoDO> {

    private final ThreadPoolTaskExecutor taskExecutor;

    public DemoService(ThreadPoolTaskExecutor taskExecutor){
        this.taskExecutor = taskExecutor;
    }

    public void deleteAll(){
        mapper.deleteAll();
    }

    @Async
    public void asyncTest(){
        System.out.println(Thread.currentThread().getName());

        taskExecutor.submit(()-> System.out.println(Thread.currentThread().getName()));
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduleTest(){
        System.out.println(Thread.currentThread().getName());
    }

    @EventHandler
    public void handleEvent(TestArg testArg){
        System.out.println("service print : " + testArg.getName());
    }
}
