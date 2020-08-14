package com.demo.SpringBootPoject.lifecycledemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class AwareInterfaceImpl implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, 
									BeanPostProcessor, InitializingBean, DisposableBean {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext() method called...");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory() method called...");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName() method called...Bean name : "+name);
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process Before Initialization method is called : Bean Name " + beanName);
		return bean; 
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process After Initialization method is called : Bean Name " + beanName);
		return bean;
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method of Book bean called !! ");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method of Book bean is called !! ");
	}
	
	@PostConstruct
	public void customInit() throws Exception {
		System.out.println("customInit method of Book bean is called !! ");
	}
	
	@PreDestroy
	public void customDestroy() throws Exception {
		System.out.println("customDestroy method of Book bean is called !! ");
	}
}
