package com.springregister.ex02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.springregister.ServiceProxyHandler;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	static final Map<String, Object> INTERFACE_CACHE = new ConcurrentHashMap<>();

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;

		Map<String, RegistryConfigBean> springConfBeanMap = beanFactory.getBeansOfType(RegistryConfigBean.class);
		springConfBeanMap.values().forEach(springConfBean -> {
			String interfaceClassName = springConfBean.getInterfaceClassName();
			Class<?> interfaceClass = springConfBean.getInterfaceClass();

			INTERFACE_CACHE.put(interfaceClassName, new ServiceProxyHandler().create(interfaceClass));

			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(interfaceClassName);
			AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
			defaultListableBeanFactory.registerBeanDefinition(interfaceClassName, beanDefinition);
		});
	}

}
