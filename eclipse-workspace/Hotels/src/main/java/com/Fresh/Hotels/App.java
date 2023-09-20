package com.Fresh.Hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
//	@Autowired
//	@Qualifier("burgerKing")

	public static void mainT(String[] args) {
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("context.xml");
//		AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("context2.xml");
//		ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("context2.xml");
		ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("NoXML.xml");
		Hotel hotel = context3.getBean("burgerKing", BurgerKing.class);
		System.out.println(hotel.message());
		System.out.println(hotel.deliveryStatus());
		scopeTesting();
//		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("");
//	        System.out.println(Tacobell.class);
//		       System.out.println(Hotel.class);
//		       System.out.println(Object.class);
//		       System.out.println(Hotel.class.getName());
		// Hotel hotel1 = context.getBean("bean1", Hotel.class);
		// Hotel hotel2 = context.getBean("bean2",Hotel.class);

//	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		// System.out.println(hotel1.menu());
		// System.out.println(hotel2.menu());
		// System.out.println(hotel1.message());

		// System.out.println("order status:\n"+hotel1.deliveryStatus());
		// context.close();
//		System.out.println("SInjection file");
//		Tacobell Shotel = context2.getBean("bean1", Tacobell.class);
//		Tacobell Shotel2 = context2.getBean("bean1", Tacobell.class);
//		System.out.println(Shotel.deliveryStatus());
//		System.out.println(Shotel.message());
//		System.out.println("Thank you " + Shotel.getName() + "\n Visit Again...");
//		System.out.println("order phNo " + Shotel.getNumber());
//	         Shotel.setName("Peni");  
//	         System.out.println(Shotel2.getName());
//	         Shotel2.setName("Dani");  // Daniel ->Dani
//	         System.out.println(Shotel.getName());  // peni
//	         System.out.println(Shotel2.getName()); //Dani

//		context2.close();
		context3.close();
//		defaultScope();
//		prototypeScope();
//		annotation();

	}

	public static void defaultScope() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context2.xml");
		Tacobell hotel1 = context.getBean("default", Tacobell.class);
		Tacobell hotel2 = context.getBean("default", Tacobell.class);
		boolean compare = hotel1 == hotel2;
		System.out.println("hotel1 and hotel2 are same :" + compare + " Having same reference in heap");
		System.out.println(compare);
		context.close();
	}

	public static void prototypeScope() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context2.xml");
		Tacobell hotel1 = context.getBean("prototype", Tacobell.class);
		Tacobell hotel2 = context.getBean("prototype", Tacobell.class);
		boolean compare = hotel1 == hotel2;
		System.out.println(
				"hotel1 and hotel2 are Not same :" + compare + " Having different reference in heap(new Object())");
		System.out.println(compare);
		context.close();
	}

	public static void annotation() {
		// Creating Annotation with help of XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("NoXML.xml");
		Hotel hotel1 = context.getBean("burger", Hotel.class);
		System.out.println(hotel1.menu());
		context.close();
	}

	public static void scopeTesting() {
		// public static void main(String[] args){
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("NoXML.xml");) {
			Hotel hotel1 = context.getBean("burgerKing", Hotel.class);
			Hotel hotel2 = context.getBean("burgerKing", Hotel.class);
			System.out.println("Singleton Scope\n" + "Address of hotel : " + hotel1);
			System.out.println("Address of hotel2 : " + hotel2);
			System.out.println("comparing hotel1 and hotel2 : " + (hotel1 == hotel2));
		}
	}

//	public static void main(String[] args) {
//		try {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigTest.class);
//		System.out.println("successfully loaded....");
//	}catch(Exception e) {
//		e.printStackTrace();
//		e.getMessage();
//	}
//		}

}
