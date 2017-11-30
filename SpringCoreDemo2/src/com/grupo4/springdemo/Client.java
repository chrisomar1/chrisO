package com.grupo4.springdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Object Construction | Done by Developer
		/*Employee eRf = new Employee();
		eRf.seteId(101);
		eRf.seteName("Sponge Bob Square Pants");
		eRf.seteAddress("Pineapple at Bikini Bottom");
		
		System.out.println("Employee details: "+eRf);
		
		// Spring Way | IOC (Investion Of Control)
		Resource resource = new ClassPathResource("employeebean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        
        Employee emp1 = (Employee) factory.getBean("emp1");
        Employee emp2 = factory.getBean("emp2", Employee.class);
        
        System.out.println("Employee details: "+emp1);
        System.out.println("Employee details: "+emp2);*/
		
        ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");
        Employee emp3 = (Employee)context.getBean("emp3");
        System.out.println("Employee3 Details: "+emp3);
        
        ClassPathXmlApplicationContext cxt = (ClassPathXmlApplicationContext)context;
        cxt.close();
        
        System.out.println(" -- Context closed -- ");

	}

}
