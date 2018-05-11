package com.springregister.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * 利用自定的注解，在Bean初始化之前完成对注入字段的赋值，
	 * 实际TestService并未注册到Spring Context中，所以通过applicationContext并不能获取TestService对象。
	 */

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/springregister/ex04/spring.xml");
		CallService callService = applicationContext.getBean(CallService.class);
		callService.call();
	}

}
