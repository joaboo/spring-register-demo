package com.springregister.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springregister.TestService;

public class Main {

	/**
	 * 利用Spring Bean生命周期的拓展，手动将指定的Service Interface注册到Spring Context对象中。
	 */

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/springregister/ex02/spring.xml");
		TestService testService = applicationContext.getBean(TestService.class);
		System.out.println(testService.helloWorld());
	}

}
