package com.bird.samples.controller;

import com.bird.websocket.common.server.WebSocketPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuxx
 * @since 2020/12/29
 */
@Controller
public class WebSocketController {

    private final WebSocketPublisher webSocketPublisher;

    public WebSocketController(WebSocketPublisher webSocketPublisher) {
        this.webSocketPublisher = webSocketPublisher;
    }

    @GetMapping("/websocket")
    public String socket() {
        return "/webSocket";
    }

    @ResponseBody
    @GetMapping("/websocket/send")
    public void send(String userId) {
//        webSocketPublisher.sendMessage("hello," + userId, userId);
    }
}
