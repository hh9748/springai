package com.atguigu.ai.all.func;

import java.util.function.Function;

/**
 * 查询候选人应聘的岗位。
 */
public class RecruitServiceFunction implements Function<RecruitServiceFunction.Request, RecruitServiceFunction.Response> {

    @Override
    public Response apply(Request request) {
        String position="未知";
        if(request.name.contains("张三")){
            position="算法工程师";
        }
        return new Response(position);
    }

    public record Request(String name){ }
    public record Response(String position){ }
}