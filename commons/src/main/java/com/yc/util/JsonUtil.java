package com.yc.util;

import com.google.gson.Gson;
import com.yc.domain.Message;

public class JsonUtil {

	/** 将对象转化为Json字符 */
	public static String transToJson(Message message) {
		Gson gson = new Gson();
		String text = gson.toJson(message);
		return text;
	}

	/** 将Json字符转化为对象 */
	public static Message transToBean(String text) {
		Gson gson = new Gson();
		Message message = gson.fromJson(text, Message.class);
		return message;
	}

}
