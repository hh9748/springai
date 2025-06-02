package com.atguigu.ai.chat.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/30 22:06
 * @description: 自定义聊天
 */
@RestController
public class ChatController {
    //构造方式注入
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(value = "msg",defaultValue = "给我讲个笑话")
                       String message) {
        //prompt:提示词
        return this.chatClient.prompt()
                //用户输入的信息
                .user(message)
                //请求大模型
                .call()
                //返回文本
                .content();
    }

}
