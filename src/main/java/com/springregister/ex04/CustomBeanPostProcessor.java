package com.springregister.ex04;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.springregister.ServiceProxyHandler;

public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Class<?> clazz = bean.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			try {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				Referer referer = field.getAnnotation(Referer.class);
				if (referer != null) {
					Object value = new ServiceProxyHandler().create(field.getType());
					if (value != null) {
						field.set(bean, value);
					}
				}
			} catch (Exception e) {
				throw new BeanInitializationException("postProcessBeforeInitialization exception", e);
			}
		}
		return bean;
	}
}
