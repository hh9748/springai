package com.atguigu.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {
    
    @Tool
    double sum(
            @ToolMemoryId int memoryId,
            @P(value="加数1", required = true) double a,
            @P(value="加数1", required = true) double b) {
        System.out.println("调用加法运算 ，memoryId" + memoryId);
        return a + b;
    }

    @Tool
    double squareRoot(
            @ToolMemoryId int memoryId,
            double x) {
        System.out.println("调用平方根运算 ，memoryId" + memoryId);
        return Math.sqrt(x);
    }
}