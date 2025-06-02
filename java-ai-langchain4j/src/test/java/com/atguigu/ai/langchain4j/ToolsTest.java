package com.atguigu.ai.langchain4j;

import com.atguigu.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools() {
        //大语言模型本身并不擅长数学运算
        String answer = separateChatAssistant.chat(2, "1+2等于几，475695037565的平方根是多少？");
        //答案：3，689706.4865
        System.out.println(answer);
    }
}