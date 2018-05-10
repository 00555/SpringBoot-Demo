package com.loveincode.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

	private static Logger logger = null;

	public static Logger getLogger() {

		if (null == logger) {

			// JavaLangAccess access = SharedSecrets.getJavaLangAccess();
			// Throwable throwable = new Throwable();
			// int depth = access.getStackTraceDepth(throwable);
			// StackTraceElement frame = access.getStackTraceElement(throwable, depth);
			// frame.getClassName();
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			StackTraceElement e = stacktrace[2];

			logger = LoggerFactory.getLogger(e.getClassName());
			// Java8 废弃了Reflection.getCallerClass()
			// logger = Logger.getLogger(Reflection.getCallerClass().getName());
			// logger.debug("调用者类名"+Reflection.getCallerClass().getName());
		}
		return logger;
	}

}
