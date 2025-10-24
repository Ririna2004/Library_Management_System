package main.java.com.lms.lib.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.lms.lib.domain.Book;
import main.java.com.lms.lib.domain.IssueRecord;
import main.java.com.lms.lib.repository.BookRepo;
import main.java.com.lms.lib.repository.IssueRecordRepo;

@Service
public class IssueRecordService {
    @Autowired private IssueRecordRepo issueRepo;
    @Autowired private BookRepo bookRepo;

    public String issueBook(Long bookId, String username) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
        if (book.getAvailableCopies() <= 0) return "Book is currently not available.";
        if (issueRepo.findByUsernameAndReturnDateIsNull(username).stream().anyMatch(ir -> ir.getBookId().equals(bookId))) return "You already borrowed this book.";
        IssueRecord record = new IssueRecord();
        record.setBookId(bookId);
        record.setUsername(username);
        record.setIssueDate(LocalDate.now());
        record.setDueDate(LocalDate.now().plusMonths(1));
        issueRepo.save(record);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepo.save(book);
        return "Book issued successfully.";
    }

    public String returnBook(Long bookId, String username) {
        List<IssueRecord> records = issueRepo.findByUsernameAndReturnDateIsNull(username);
        IssueRecord recordToReturn = records.stream().filter(ir -> ir.getBookId().equals(bookId)).findFirst().orElse(null);
        if (recordToReturn == null) return "No record found for borrowed book.";
        recordToReturn.setReturnDate(LocalDate.now());
        issueRepo.save(recordToReturn);
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepo.save(book);
        return "Book returned successfully.";
    }

    public List<IssueRecord> getBorrowedBooks(String username) {
        return issueRepo.findByUsernameAndReturnDateIsNull(username);
    }
}
