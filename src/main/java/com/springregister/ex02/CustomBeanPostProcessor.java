package com.springregister.ex02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class CustomBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		try {
			Object bean = CustomBeanFactoryPostProcessor.INTERFACE_CACHE.get(beanName);
			if (bean != null) {
				return bean;
			}
		} catch (Exception e) {
		}
		return super.postProcessBeforeInstantiation(beanClass, beanName);
	}

}
