package com.loveincode.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.loveincode.utils.LogUtils;

@Component
public class scheduleTest {
	
	@Scheduled(fixedDelayString = "5000", initialDelayString = "1000")
	public void Test() throws InterruptedException {
		LogUtils.getLogger().info(Thread.currentThread() + "定时执行 start");
		Thread.sleep(6000);
		LogUtils.getLogger().info(Thread.currentThread() + "定时执行 end");
	}

}
