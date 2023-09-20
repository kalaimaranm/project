package in.springcore.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringcoreApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("container created successfully.....");

        Pen pen = context.getBean("pen", Pen.class);
//        pen.setName("Parker");
//        pen.setPrice(549.00);
//        pen.setQuantity(10);
         System.out.println("pen : " + pen);
         System.out.println(pen.getName()[0]);
         System.out.println(pen.getName()[1]);
//        System.out.println(context.getBean("pen",Pen.class));
//        System.out.println(context.getBean("pen",Pen.class));
//        System.out.println(context.getBean("pen",Pen.class));
    }
}
