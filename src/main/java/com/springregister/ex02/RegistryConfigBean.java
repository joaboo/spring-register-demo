package com.springregister.ex02;

import org.springframework.beans.factory.InitializingBean;

public class RegistryConfigBean implements InitializingBean {

	private String interfaceClassName;
	private Class<?> interfaceClass;

	public String getInterfaceClassName() {
		return interfaceClassName;
	}

	public Class<?> getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClassName(String interfaceClassName) {
		this.interfaceClassName = interfaceClassName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		interfaceClass = Class.forName(interfaceClassName);
	}

}
