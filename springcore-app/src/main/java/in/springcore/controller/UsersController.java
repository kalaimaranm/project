package in.springcore.controller;

import in.springcore.bean.User;
import in.springcore.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {

        return usersService.getUsers().toString();
    }

//    public UsersService getUsersService() {
//        return usersService;
//    }
//
//    public void setUsersService(UsersService usersService) {
//        this.usersService = usersService;
//    }

}
