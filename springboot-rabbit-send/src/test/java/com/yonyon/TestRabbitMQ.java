package com.yonyon;

import com.yonyon.service.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yinmb
 * @Date 2019/3/20 14:57:37
 */
@SpringBootTest(classes=SpringbootRabbitSendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testRabbit() {
    //    helloSender.send();

        rabbitTemplate.convertAndSend("fanoutExchange","","fanout,你们好");
    }

    @Test
    public void testRabbit1() {
        System.out.println(rabbitTemplate.receiveAndConvert("fanout.C"));
    }
}
