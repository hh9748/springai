package com.atguigu.ai.langchain4j;

import com.atguigu.ai.langchain4j.assistant.MemoryChatAssistant;
import com.atguigu.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemMessage01() {
        String answer = separateChatAssistant.chat(3,"我是谁");
        System.out.println(answer);
    }

    @Test
    public void testSystemMessage02() {
        String answer = separateChatAssistant.chat(4,"今天是几号");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testUserMessage() {
        String answer = memoryChatAssistant.chat("我是Mr 浩");
        System.out.println(answer);
        String answer1 = memoryChatAssistant.chat("我28岁了");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("你知道我是谁吗");
        System.out.println(answer2);
    }


    @Test
    public void testV() {
        String answer1 = separateChatAssistant.chat2(5, "我是浩仔");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat2(5, "我是谁");
        System.out.println(answer2);
    }


    @Test
    public void testUserInfo() {
        //从数据库中获取用户信息
        String username = "翠花";
        int age = 18;
        String answer = separateChatAssistant.chat3(6, "我是谁，我多大了", username, age);
        System.out.println(answer);
    }
}