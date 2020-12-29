package com.bird.samples.controller;

import com.bird.websocket.common.server.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuxx
 * @since 2020/12/29
 */
@Controller
public class WebSocketController {

    private final WebSocketServer webSocketServer;

    public WebSocketController(WebSocketServer webSocketServer) {
        this.webSocketServer = webSocketServer;
    }

    @GetMapping("/websocket")
    public String socket() {
        return "/webSocket";
    }

    @ResponseBody
    @GetMapping("/websocket/send")
    public void send(String userId) {
        webSocketServer.sendMessage("hello," + userId, userId);
    }
}
