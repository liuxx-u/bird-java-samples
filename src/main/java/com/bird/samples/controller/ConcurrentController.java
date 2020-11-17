package com.bird.samples.controller;

import com.bird.samples.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxx
 * @since 2020/11/11
 */
@RestController
@RequestMapping("/concurrent")
public class ConcurrentController {

    private final DemoService demoService;

    public ConcurrentController(DemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping("/asyncTest")
    public void asyncTest(){
        System.out.println(Thread.currentThread().getName());
        this.demoService.asyncTest();
    }
}
