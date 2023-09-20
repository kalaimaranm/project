package in.spring.web;

import in.spring.web.model.User;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/outer")
public class SampleController {

//    matric variable in url /user/35;p=8/orders p is pagination
    @GetMapping("/hi/{userId}")
    @ResponseBody                                    //optional parameter default true which mean must un is required
    public String sayHello(@RequestParam(name = "un", required = false) String name,
            @PathVariable(name = "userId", required = false) Integer userId) {
        if (Objects.nonNull(name) && !name.isEmpty()) {
            return "Hello, it's Now: " + LocalDateTime.now() + "\n Hello, " + name + " userid : " + userId;
        }
        return "Hello, it's Now: " + LocalDateTime.now();
    }

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_XML_VALUE)
//    @ResponseBody
    public String getUser(ModelMap data) {
        data.addAttribute("user", new User(1, "James", 45));

        return "viewPage1";
    }

}
