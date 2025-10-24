package main.java.com.lms.lib.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
    @Id
    private String username;
    private String password;

    public Login() {}
    public Login(String username, String password) {
        this.username = username; this.password = password;
    }
    // Getters and setters ...
}
