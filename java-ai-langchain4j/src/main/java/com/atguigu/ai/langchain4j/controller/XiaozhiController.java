package com.atguigu.ai.langchain4j.controller;

import com.atguigu.ai.langchain4j.assistant.XiaozhiAgent;
import com.atguigu.ai.langchain4j.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "硅谷小智")
@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {

    @Autowired
    private XiaozhiAgent xiaozhiAgent;

    /**
     * 测试结果
     * 好的，小浩仔！我将为你预约明天下午2:00 - 4:00的消化内科张医生。
     *
     * ### 预约信息确认
     * - **姓名**：小浩仔
     * - **身份证号**：421023199704086125
     * - **预约科室**：消化内科
     * - **预约医生**：张医生
     * - **预约日期**：2025-06-02
     * - **预约时间**：下午2:00 - 4:00
     *
     * ### 预约成功
     * 你的预约已经成功安排。请记得按时前往医院，并带上身份证和医保卡（如果有的话）。
     *
     * ### 就诊前的注意事项
     * - **保持水分**：继续多喝水或口服补液盐，以防脱水。
     * - **清淡饮食**：暂时避免油腻、辛辣和难以消化的食物。
     * - **充分休息**：让身体有时间恢复。
     *
     * 希望你早日康复！如果有其他问题或需要进一步的帮助，请随时告诉我。🌟
     * @param chatForm
     * @return
     */
    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm)  {
        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}