package com.springregister.ex03;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;

		Map<String, RegistryConfigBean> springConfBeanMap = beanFactory.getBeansOfType(RegistryConfigBean.class);
		springConfBeanMap.values().forEach(springConfBean -> {
			String interfaceClassName = springConfBean.getInterfaceClassName();

			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(interfaceClassName);
			AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(interfaceClassName);
			beanDefinition.setBeanClass(ServiceProxyFactoryBean.class);
			beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

			defaultListableBeanFactory.registerBeanDefinition(interfaceClassName, beanDefinition);
		});
	}

}
