package main.java.com.lms.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.com.lms.lib.domain.Login;

@Repository
public interface RegRepo extends JpaRepository<Login, String> {
    Login findByUsername(String username);
}
