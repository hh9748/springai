package com.atguigu.ai.chat.controller;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/30 22:42
 * @description: 聊天模型
 */
@RestController
public class ChatModelController {
    @Autowired
    private ChatModel chatModel;

    /**
     * default String call(String message) {...}
     *
     * @param msg
     * @return
     */
    @GetMapping("/chatModel01")
    public String chatModel01(@RequestParam("msg") String msg) {
        return chatModel.call(msg);
    }

    /**
     * ChatResponse call(Prompt prompt);
     *
     * @param msg
     * @return
     */
    @GetMapping("/chatModel02")
    public String chatModel02(@RequestParam("msg") String msg) {
        ChatResponse call = chatModel.call(new Prompt(msg,
                ChatOptions.
                        builder().model("deepseek-chat")
                        .temperature(0.8)
                        .build()));

        return call.getResult().getOutput().getContent();

    }

    /**
     * 提示词 prompt
     * 与模型交互的一种输入数据组织方式
     * @param name 名字
     * @param voice 习惯
     * @return
     */
    @GetMapping("/prompt")
    public String prompt(@RequestParam("name")
                         String name,
                         @RequestParam("voice")
                         String voice){
        String userText= """
            给我推荐北京的至少三种美食
            """;
        UserMessage userMessage = new UserMessage(userText);
        String systemText= """
            你是一个美食咨询助手，可以帮助人们查询美食信息。
            你的名字是{name},
            你应该用你的名字和{voice}的饮食习惯回复用户的请求。
            """;
        // Prompt Template 提示词模板管理抽象，开发者可以预先定义好模板，并在运行时替换模板中的关键词
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemText);
        //替换占位符
        Message systemMessage = systemPromptTemplate
                .createMessage(Map.of("name", name, "voice", voice));
        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
        List<Generation> results = chatModel.call(prompt).getResults();
        return results.stream().map(x->x.getOutput().getContent()).collect(Collectors.joining(""));
    }

}
