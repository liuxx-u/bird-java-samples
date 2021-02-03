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
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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

    @Transactional(rollbackFor = Exception.class)
    public void repeatReadTest() {
        String id = "0kfdaanom-2r3lei-n99pgt-000000";
        DemoDO demo = super.getById(id);
        System.out.println("oldName:" + demo.getName());

        String newName = UUID.randomUUID().toString();

        mapper.updateTest(id,newName);

        System.out.println("newName:" + newName);

        DemoDO demo2 = super.getById("0kfdaanom-2r3lei-n99pgt-000000");
        System.out.println("repeatRead:" + demo2.getName());
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
