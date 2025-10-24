package main.java.com.lms.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.java.com.lms.lib.domain.Book;

public interface BookRepo extends JpaRepository<Book, Long> { }
