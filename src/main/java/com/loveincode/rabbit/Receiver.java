package com.loveincode.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello") //注解定义该类对hello队列的监听
//消息消费者
public class Receiver {

    @RabbitHandler //注解来指定对消息的处理方法
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

}
