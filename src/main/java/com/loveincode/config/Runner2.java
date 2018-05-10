package com.loveincode.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.loveincode.utils.LogUtils;

@Component
@Order(2)
public class Runner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		LogUtils.getLogger().info("The runner (2) start to initialize ... ");

	}

}
