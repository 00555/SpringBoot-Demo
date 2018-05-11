package com.loveincode.utils;

import java.util.UUID;

public class ToolsUtil {
	
	/**
	 * 得到全球唯一UUID
	 * 
	 * @return 全球唯一UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉"-"符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}
	
	
}
