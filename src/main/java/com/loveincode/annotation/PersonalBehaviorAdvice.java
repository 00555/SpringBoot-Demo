package com.loveincode.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.loveincode.utils.LogUtils;

@Aspect
@Component
public class PersonalBehaviorAdvice {

	@Pointcut("execution(public * com.loveincode.controller.*.*(..))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before(JoinPoint jp) {
		LogUtils.getLogger().info("在" + jp.getSignature().getName() + "執行之前切入的內容.");
	}
	
	@After("pointcut()")
	public void after(JoinPoint jp) {
		LogUtils.getLogger().info("在" + jp.getSignature().getName() + "執行之后切入的內容.");
	}
	
	@AfterReturning(pointcut = "pointcut()", returning = "ret")
	public void afterReturning(JoinPoint jp, Object ret) {
		LogUtils.getLogger().info("在" + jp.getSignature().getName() + "執行之后切入的內容.請求參數是:" + jp.getArgs() + "返回內容為:" + ret);
	}
	
	@AfterThrowing("pointcut()")
	public void afterThrow(JoinPoint jp) {
		LogUtils.getLogger().info("在" + jp.getSignature().getName() + "執行之后切入的內容.出現了異常");
	}
}
