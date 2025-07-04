package com.atguigu.ai.langchain4j.config;

import com.atguigu.ai.langchain4j.store.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * java-ai-langchain4j
 *
 * @author: hh
 * @createTime: 2025/06/01 16:31
 * @description:
 */
@Configuration
public class SeparateChatAssistantConfig {
    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
//                .chatMemoryStore(new InMemoryChatMemoryStore())
                .chatMemoryStore(mongoChatMemoryStore)
                .build();

    }
}
