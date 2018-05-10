package com.loveincode.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.loveincode.utils.LogUtils;

@Component
@EnableScheduling
public class SchedulerTask {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Scheduled(fixedRate=8000)
	public void printTimePer5s() {
		LogUtils.getLogger().info("Now datetime is : " + sdf.format(new Date()));
	}
}
