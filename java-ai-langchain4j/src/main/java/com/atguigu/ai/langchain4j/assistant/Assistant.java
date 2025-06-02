package com.atguigu.ai.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 助手
 */
//因为我们在配置文件中同时配置了多个大语言模型，所以需要在这里明确指定（EXPLICIT）模型的beanName
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel="qwenChatModel"
)
public interface Assistant {
    String chat(String userMessage);
}