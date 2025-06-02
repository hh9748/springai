package com.atguigu.ai.ollama.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/31 12:00
 * @description:
 */
@RestController
public class OllamaController {
    @Autowired
    private OllamaChatModel chatModel;

    @GetMapping("/ollama")
    public String generate(@RequestParam(value = "message", defaultValue = "hello")
                           String message) {
        String response = chatModel.call(message);
        System.out.println("response : "+response);
        return response;
    }
}
