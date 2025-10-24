package main.java.com.lms.lib.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.lms.lib.domain.Book;
import main.java.com.lms.lib.repository.BookRepo;

@Service
public class BookService {
    @Autowired private BookRepo rep;
    public List<Book> listAll() { return rep.findAll(); }
    public void save(Book book) { rep.save(book); }
    public Book get(long id) { return rep.findById(id).orElseThrow(() -> new RuntimeException("Book not found with ID: " + id)); }
    public void delete(long id) {
        if (!rep.existsById(id)) throw new RuntimeException("Cannot delete, book not found with ID: " + id);
        rep.deleteById(id);
    }
}
