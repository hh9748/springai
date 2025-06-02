package com.atguigu.ai.chat.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/30 22:20
 * @description:
 */
@RestController
public class ChatAIController {
    @Autowired
    private ChatClient chatClient;

    /**
     * 非流式输出 call：等待大模型把回答结果全部生成后输出给用户；
     *
     * 另一方面当模型推理效率不是很高时，流式输出比起全部生成后再输出大大提高用户体验。
     * @param message
     * @return
     */
    @GetMapping("/chatAi")
    public String chat(@RequestParam(value = "msg") String message) {
        return chatClient.prompt().user(message).call().content();
    }

    /**
     * 流式输出stream：逐个字符输出，一方面符合大模型生成方式的本质，
     * 另一方面当模型推理效率不是很高时，流式输出比起全部生成后再输出大大提高用户体验。
     *
     * produces---乱码处理（输出格式和编码方式）
     * @param message
     * @return
     */
    @GetMapping(value = "/chatAi/stream",produces="text/html;charset=UTF-8")
    public Flux<String> chatStream(@RequestParam(value = "msg") String message) {
        return chatClient.prompt().user(message).stream().content();
    }


}
