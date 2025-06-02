package com.atguigu.ai.langchain4j;

import com.atguigu.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * java-ai-langchain4j
 *
 * @author: hh
 * @createTime: 2025/06/01 20:36
 * @description:
 */
@SpringBootTest
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
    *     插入文档
    */
//    @Test
//    public void testInsert01() {
//        mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
//
//    }

    @Test
    public void testInsert02() {
        ChatMessages messages = new ChatMessages();
        messages.setContent("聊天记录");
        mongoTemplate.insert(messages);

    }
    /**
     * 根据id查询文档
     */
    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("683c4a89157a80160a072710", ChatMessages.class);
        System.out.println(chatMessages);
    }


    /**
     * 修改文档
     */
    @Test
    public void testUpdate() {

        Criteria criteria = Criteria.where("_id").is("683c4a89157a80160a072710");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录列表");

        //修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    /**
     * 新增或修改文档
     */
    @Test
    public void testUpdate2() {

        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录列表2");

        //修改或新增---这样新增的数据没有_class
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }


    /**
     * 删除文档
     */
    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }



}
