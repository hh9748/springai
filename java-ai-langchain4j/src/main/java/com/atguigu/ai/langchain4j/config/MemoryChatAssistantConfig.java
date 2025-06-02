package com.atguigu.ai.langchain4j.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * java-ai-langchain4j
 *
 * @author: hh
 * @createTime: 2025/06/01 16:18
 * @description:
 */
@Configuration
public class MemoryChatAssistantConfig {
    @Bean
    public ChatMemory chatMemory(){
        //设置聊天记忆记录的message数量
        return MessageWindowChatMemory.withMaxMessages(10);
    }
}
