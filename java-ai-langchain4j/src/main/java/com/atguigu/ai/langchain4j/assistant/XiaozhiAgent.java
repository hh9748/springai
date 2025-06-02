package com.atguigu.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * java-ai-langchain4j
 *
 * @author: hh
 * @createTime: 2025/06/01 21:40
 * @description: 硅谷小智
 */
@AiService(
        wiringMode = EXPLICIT,
//        chatModel = "qwenChatModel",
        streamingChatModel = "qwenStreamingChatModel",//流式输出大模型
        chatMemoryProvider = "chatMemoryProviderXiaozhi",
        tools = "appointmentTools",
//        contentRetriever = "contentRetrieverXiaozhi" //配置向量存储
        contentRetriever = "contentRetrieverXiaozhiPincone"  //配置Pincone向量存储
)
public interface XiaozhiAgent {
    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
