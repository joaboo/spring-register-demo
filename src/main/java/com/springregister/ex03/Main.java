package com.springregister.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springregister.TestService;

public class Main {

	/**
	 * ex01和ex02的结合，更灵活拓展（Mybatis就是使用类似方式）
	 */

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/springregister/ex03/spring.xml");
		TestService testService = applicationContext.getBean(TestService.class);
		System.out.println(testService.helloWorld());
	}

}
