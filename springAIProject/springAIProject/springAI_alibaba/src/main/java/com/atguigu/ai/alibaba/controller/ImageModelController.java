package com.atguigu.ai.alibaba.controller;

import com.alibaba.cloud.ai.dashscope.api.DashScopeImageApi;
import com.alibaba.cloud.ai.dashscope.image.DashScopeImageOptions;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * springAIProject
 *
 * @author: hh
 * @createTime: 2025/05/31 22:15
 * @description: 图像模型
 */
@RestController
public class ImageModelController {
    private final ImageModel imageModel;

    ImageModelController(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping("/image")
    public void getMsg(@RequestParam( value = "/msg",defaultValue = "生成一只小猫")String msg, HttpServletResponse response) {
        DashScopeImageOptions imageOptions = DashScopeImageOptions.builder()
                .withModel(DashScopeImageApi.DEFAULT_IMAGE_MODEL)
                .withN(1)
                .withHeight(1024)
                .withWidth(1024)
                .build();

        ImagePrompt imagePrompt = new ImagePrompt(msg, imageOptions);
        ImageResponse res = imageModel.call(imagePrompt);
        //生成地址
        String imageUrl = res.getResult().getOutput().getUrl();

        try {
            //使用输出流在浏览器输出
            URL url = URI.create(imageUrl).toURL();
            InputStream in = url.openStream();
            response.setHeader("Content-Type", MediaType.IMAGE_PNG_VALUE);
            response.getOutputStream().write(in.readAllBytes());
            response.getOutputStream().flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
