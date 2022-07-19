package com.example.demowebsocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("*")
public class MessageController {

    @MessageMapping("/hello") // Tưởng tượng giống requestMapping, value là giá trị của endpoint mà chúng ta đã cấu hình trong class WebSocketConfiguration
    @SendTo("/topic/messages") // Giá trị được khai báo trong @SendTo phải bắt đầu giống với giá trị chúng ta đã khai báo trong phương thức enableSimpleBroker()
    public String send(String message) {
        return message;
    }
}
