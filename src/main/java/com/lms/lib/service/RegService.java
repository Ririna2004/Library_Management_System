package main.java.com.lms.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.lms.lib.domain.Login;
import main.java.com.lms.lib.repository.RegRepo;

@Service
public class RegService {
    @Autowired private RegRepo rep;
    public boolean registerUser(String username, String password) {
        if (rep.findByUsername(username) != null) return false;
        rep.save(new Login(username, password));
        return true;
    }
}
