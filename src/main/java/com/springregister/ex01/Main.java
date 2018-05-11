package com.springregister.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springregister.TestService;

public class Main {

	/**
	 * 实际注入对象为SpringConfBean，而由于SpringConfBean实现了FactoryBean，
	 * 其中getObjectType()实际返回TestService.Class，getObject()实际返回TestService的JDK代理类，
	 * 从而达到手动将指定Service Interface注册到Spring Context的目的。
	 */

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/springregister/ex01/spring.xml");
		TestService testService = applicationContext.getBean(TestService.class);
		System.out.println(testService.helloWorld());
	}

}
