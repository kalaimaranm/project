package in.springcore.service;

import in.springcore.app.UsersRepository;
import in.springcore.bean.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> getUsers() {
        
        
        
        return usersRepository.getUser();
    }
}
