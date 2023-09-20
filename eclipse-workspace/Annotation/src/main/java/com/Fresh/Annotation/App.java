package com.Fresh.Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main2(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Human human = context.getBean("bean1", Human.class);
		System.out.println(human.alive("kalaimaran"));
		System.out.println(human.blood("kalaimaran")); // not tested
	}
	public static void main(String[] args) {
	    var i = 10;
	    var j = 10;
	    System.out.println(i==j);  // true
	    var I = (Integer) 10;
	    var J = (Integer) 10;
	    System.out.println(I==J); // false
		System.out.println("Hello World");
		var n = 42; // n has type 'int' 
        method(n);   // int method
	}
	public void method(Integer i) {
    System.out.print("Integer method");
}
   public static void method(int i) {
    System.out.print("int method");
}
	
}
