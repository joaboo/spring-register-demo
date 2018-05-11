package com.springregister.ex04;

import com.springregister.TestService;

public class CallService {

	@Referer
	private TestService testService;

	public void call() {
		System.out.println(testService.helloWorld());
	}

}
