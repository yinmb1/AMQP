package com.yonyon.service;

import com.yonyon.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yinmb
 * @Date 2019/3/20 17:35:31
 */
@Component
public class HelloReceive {

    @Autowired
    RabbitTemplate rabbitTemplate;
    /** Direct模式 **/
    @RabbitListener(queues="queue")
    public void processC(User str) {
        //监听器监听指定的Queue
        System.out.println("Receive:"+str.getPassWord()+str.getUserName());
    }

    /** Topic转发模式 **/
    @RabbitListener(queues="topic.message")
    public void process1(String str) {
        //监听器监听指定的Queue
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.messages1")
    public void process2(String str) {
        //监听器监听指定的Queue
        System.out.println("messages1:"+str);
    }

    /** Fanout Exchange形式  **/
    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }
    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener()
    public void processC(Object str) {
      //  System.out.println("ReceiveC:"+str);

        System.out.println(rabbitTemplate.receiveAndConvert("fanout.C"));
    }

}
