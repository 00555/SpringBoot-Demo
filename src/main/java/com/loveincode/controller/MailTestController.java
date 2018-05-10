package com.loveincode.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loveincode.common.Result;
import com.loveincode.common.ResultGenerator;
import com.loveincode.utils.MailBody;
import com.loveincode.utils.MailUtils;

@RestController
@RequestMapping("/email")
public class MailTestController {
	@PostMapping("/send")
	public Result sendEmail() {
		MailBody mb = new MailBody();
		mb.setCause("TEST");
		mb.setMessageCode("200");
		mb.setMessageStatus("SUCCESS");
		try {
			MailUtils.sendMessageMail(mb, "Test mail", "13662005880@163.com");
		} catch (Exception e) {
			return ResultGenerator.genFailResult(e.getMessage());
		}
		return ResultGenerator.genSuccessResult().setMessage("Email send successfully.");
	}
}
