package src.main.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {

    @RequestMapping("/welcome")
    public String homeView() {

        return "home";
    }
//@PostMapping("")
//@GetMapping
    @RequestMapping("/login")
    public String loginView() {

        return "login";
    }
}
