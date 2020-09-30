package com.bird.samples.controller;

import com.bird.samples.model.TraceDemoDO;
import com.bird.samples.service.TraceDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liuxx
 * @since 2020/9/30
 */
@RestController
@RequestMapping("/trace/field")
public class TraceFieldController {

    private final TraceDemoService traceDemoService;

    public TraceFieldController(TraceDemoService traceDemoService) {
        this.traceDemoService = traceDemoService;
    }

    @GetMapping("/insert")
    public void insert() {
        TraceDemoDO traceDemo = new TraceDemoDO().setName("liuxx").setDescription("desc").setNum(1).setDate(new Date());
        traceDemoService.insert(traceDemo);
    }

    @GetMapping("/update")
    public void update() {
        String updateValue = UUID.randomUUID().toString();

        TraceDemoDO traceDemo = traceDemoService.lambdaQuery().eq(TraceDemoDO::getName,"liuxx").last("limit 1").one();
        traceDemo.setName(updateValue).setDescription(updateValue).setNum(ThreadLocalRandom.current().nextInt(100)).setDate(new Date());
        traceDemoService.update(traceDemo);
    }

    @GetMapping("/delete")
    public void delete() {
        TraceDemoDO traceDemo = traceDemoService.lambdaQuery().last("limit 1").one();
        traceDemoService.delete(traceDemo.getId());
    }
}
