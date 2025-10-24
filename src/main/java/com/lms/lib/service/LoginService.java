package main.java.com.lms.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.lms.lib.domain.Login;
import main.java.com.lms.lib.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired private LoginRepo rep;
    public Login log(String username, String password) {
        return rep.findByUsernameAndPassword(username, password);
    }
}
