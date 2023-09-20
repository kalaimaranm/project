package in.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScan(basePackages = "in.test")
@RequestMapping("/outer")
public class Beans {

    
    @RequestMapping("/test")
    public String viewTest(){
        return "";
    }
}
