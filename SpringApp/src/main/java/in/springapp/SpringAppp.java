package in.springapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

            Tacobell bean = (Tacobell) context.getBean("mybean");
            System.out.println(bean.getAddress());

//            Hotel hotel = ctx.getBean("myCoach", Hotel.class);
//            System.out.println(hotel.menu());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //ctx.close();
        }
    }

}
