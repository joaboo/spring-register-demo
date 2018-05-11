package com.springregister.ex01;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.springregister.ServiceProxyHandler;

public class RegistryConfigBean implements FactoryBean<Object>, InitializingBean {

	private String interfaceClassName;
	private Class<?> interfaceClass;

	public void setInterfaceClassName(String interfaceClassName) {
		this.interfaceClassName = interfaceClassName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		interfaceClass = Class.forName(interfaceClassName);
	}

	@Override
	public Object getObject() throws Exception {
		return new ServiceProxyHandler().create(interfaceClass);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public Class<?> getObjectType() {
		return interfaceClass;
	}

}
