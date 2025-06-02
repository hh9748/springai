package com.atguigu.ai.langchain4j;


import com.atguigu.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * java-ai-langchain4j
 *
 * @author: hh
 * @createTime: 2025/06/01 15:50
 * @description:
 */
@SpringBootTest
public class AIServiceTest {
    @Autowired
    private QwenChatModel qwenChatModel;


    @Test
    public void testChat() {
//        创建AIService
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String chat = assistant.chat("你好呀，介绍一下你自己");
        System.out.println(chat);

    }


    @Autowired
    private Assistant assistant;
    @Test
    public void testAssistant() {
        String chat = assistant.chat("你好呀，介绍一下你自己");
        System.out.println(chat);

    }
}
