package com.springregister.ex03;

import org.springframework.beans.factory.FactoryBean;

import com.springregister.ServiceProxyHandler;

public class ServiceProxyFactoryBean implements FactoryBean<Object> {

	private Class<Object> serviceInterface;

	public ServiceProxyFactoryBean() {
	}

	public ServiceProxyFactoryBean(Class<Object> serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	@Override
	public Object getObject() throws Exception {
		return new ServiceProxyHandler().create(serviceInterface);
	}

	@Override
	public Class<Object> getObjectType() {
		return serviceInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public Class<Object> getServiceInterface() {
		return serviceInterface;
	}

	public void setServiceInterface(Class<Object> serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

}
