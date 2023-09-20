package com.Fresh.Testing.TestingProject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.Fresh.Annotation.Human;


public class App 
{
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Human human = context.getBean("bean1", Human.class);
		System.out.println(human.alive("kalaimaran"));

		System.out.println(human.blood("kalaimaran")); // not tested
	}
}
