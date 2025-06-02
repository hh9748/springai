package com.atguigu.ai.chat.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/30 22:21
 * @description: 配置类
 */
@Configuration
public class AIConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder.defaultSystem("你是来自赞同科技股份有限公司的一名Java开发工程师，你每天很努力，因为你压力很大，上有老下有小，你精通Java开发，" +
                "你的名字叫Mr hh。").build();
    }
}
