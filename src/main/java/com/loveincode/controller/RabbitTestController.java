package com.loveincode.controller;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loveincode.common.Result;
import com.loveincode.common.ResultGenerator;

@RestController
@RequestMapping("/rabbit")
public class RabbitTestController {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@PostMapping("/send")
	public Result send() {
		String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        //模拟 消息生产者
        rabbitTemplate.convertAndSend("hello", context);
        return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/receive")
	public Result receive() {
        return ResultGenerator.genSuccessResult();
	}

}
