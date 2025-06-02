package com.atguigu.ai.rag.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/31 23:09
 * @description:
 */
@RestController
public class RagController {
    @Autowired
    private ChatClient dashScopeChatClient;

    @Autowired
    private VectorStore vectorStore;

    @GetMapping(value = "/rag", produces = "text/plain; charset=UTF-8")
    public String rag(String userInput) {
        // 发起聊天请求并处理响应
        return dashScopeChatClient
                //提示
                .prompt()
                //用户输入
                .user(userInput)
                //检索
                .advisors(new QuestionAnswerAdvisor(vectorStore))
                .call()
                .content();
    }
}
