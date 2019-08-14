package com.yonyon.service;


import com.yonyon.dto.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yinmb
 * @Date 2019/3/20 14:47:03
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void send() {

        // template.convertAndSend("queue","hello,rabbit~");
        // 实现Serializable接口 并且实体类要在同一包名下
        User user=new User();
        user.setUserName("hlhdidi");
        user.setPassWord("123");
        // template.convertAndSend("queue",user);

        // template.convertAndSend("exchange", "topic.messages", "hello, rabbit!");

        // 参数2将被忽略*/
        template.convertAndSend("fanoutExchange", "", "xixi,hlhdidi");

    }
}

