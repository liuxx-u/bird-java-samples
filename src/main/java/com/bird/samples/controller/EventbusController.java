package com.bird.samples.controller;

import com.bird.eventbus.EventBus;
import com.bird.eventbus.handler.EventHandler;
import com.bird.samples.pojo.TestArg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxx
 * @since 2020/11/20
 */
@RestController
@RequestMapping("/eventbus")
public class EventbusController {

    private final EventBus eventBus;

    public EventbusController(EventBus eventBus){
        this.eventBus = eventBus;
    }

    @GetMapping("/send")
    public void send(String name){
        eventBus.push(new TestArg(name));
    }

    @EventHandler
    public void handleEvent(TestArg testArg){
        System.out.println("controller print : " + testArg.getName());
    }
}
