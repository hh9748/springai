package com.atguigu.ai.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/30 21:44
 * @description: 聊天模拟
 */
@RestController
public class ChatDeepSeekController {
    @Autowired
    private OpenAiChatModel chatModel;

    @GetMapping("/hello")
    public String generate(@RequestParam(value = "message", defaultValue = "hello")
                           String message) {
        String response = chatModel.call(message);
        System.out.println("response : "+response);
        return response;
    }

}
