package com.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spring.entity.Course;

@SuppressWarnings("deprecation")
public class App     // main class
{
	// main method
	public static void main( String[] args )
	{
		// get resource data from applicationContext.xml file 
		Resource r = new ClassPathResource("applicationContext.xml");
		// reference of beanFactory container 
		BeanFactory b = new XmlBeanFactory(r);

		// reference of entity class invoked with container
		Course c = (Course) b.getBean("course");
		// called show() method 
		c.show();
	}
}
