package com.atguigu.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * java-ai-langchain4j
 *
 * @author: hh
 * @createTime: 2025/06/01 16:28
 * @description: 记忆隔离对话智能体
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel="qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools="calculatorTools" //配置工具
)
public interface SeparateChatAssistant {
    /**
     * 分离聊天记录
     * @param memoryId 聊天id
     * @param userMessage 用户消息
     * @return
     */
//    @SystemMessage("你是我的好朋友，请用东北话回答问题。今天是{{current_date}}")//系统消息提示词
//    @SystemMessage("你是我的好朋友，请用粤语回答问题。")//--如果切换提示词之后，会出现记忆丢失
    @SystemMessage(fromResource = "my-prompt-template.txt")  //从文件中读取提示词
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);


    @UserMessage("你是我的好朋友，请用粤语回答问题。{{message}}")
    String chat2(@MemoryId int memoryId, @V("message") String userMessage);


    @SystemMessage(fromResource = "my-prompt-template3.txt")
    String chat3(
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
    );
}
