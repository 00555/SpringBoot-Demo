package com.loveincode.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.loveincode.utils.LogUtils;

@Component
@EnableScheduling //启用定时任务的配置
public class SchedulerTask {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Scheduled(fixedRate=5000) //上一次开始执行时间点之后5秒再执行
	//@Scheduled(fixedDelay = 5000) 上一次执行完毕时间点之后5秒再执行
	//@Scheduled(initialDelay=1000, fixedRate=5000)第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
	//@Scheduled(cron="*/5 * * * * *") 通过cron表达式定义规则
	public void printTimePer5s() {
		LogUtils.getLogger().info("Now datetime is : " + sdf.format(new Date()));
	}
}
