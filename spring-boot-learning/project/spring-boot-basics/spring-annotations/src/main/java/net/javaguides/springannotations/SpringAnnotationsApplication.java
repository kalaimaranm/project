package net.javaguides.springannotations;

import net.javaguides.springannotations.controller.PizzaController;
import net.javaguides.springannotations.propertysource.MessageDemo;
import net.javaguides.springannotations.propertysource.PropertySourceDemo;
import net.javaguides.springannotations.repository.MyRepository;
import net.javaguides.springannotations.service.MyService;
import net.javaguides.springannotations.value.ValueAnnotationDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAnnotationsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationsApplication.class, args);
        PizzaController pizzaController = context.getBean(PizzaController.class);
        System.out.println(pizzaController.getPizza());

        MyRepository repository = (MyRepository) context.getBean("myRepository");

        System.out.println("repo : " + repository.repository());

        MyService service = (MyService) context.getBean("myService");

        System.out.println("service : " + service.service());

        System.out.println("...................@value annotatio demo............");

        ValueAnnotationDemo valueAnnotationDemo = context.getBean(ValueAnnotationDemo.class);

        System.out.println("hostname : " + valueAnnotationDemo.getHostName());
        System.out.println("email : " + valueAnnotationDemo.getEmail());
        System.out.println("password : " + valueAnnotationDemo.getPassword());
        System.out.println("defaultvalue : " + valueAnnotationDemo.getDefaultName());

        System.out.println(".............@PropertySource custome properties file............");

        PropertySourceDemo propertySourceDemo = context.getBean(PropertySourceDemo.class);

        System.out.println("mail id : " + propertySourceDemo.getMailid());
        System.out.println("password : " + propertySourceDemo.getPassword());
        System.out.println("hostname : " + propertySourceDemo.getHostname());

        System.out.println(".............@PropertySource custome properties file-2............");

        MessageDemo messageDemo = context.getBean(MessageDemo.class);

        System.out.println("app name : " + messageDemo.getAppName());
        System.out.println("description name : " + messageDemo.getDescription());
    }

}
