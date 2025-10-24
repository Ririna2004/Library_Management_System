package main.java.com.lms.lib.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.java.com.lms.lib.domain.IssueRecord;
import main.java.com.lms.lib.service.IssueRecordService;

@Controller
@RequestMapping("/library")
public class IssueRecordController {
    @Autowired private IssueRecordService issueService;

    @GetMapping("/borrow")
    public String borrowPage() { return "borrow"; }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long bookId, @RequestParam String username, Model model) {
        String message = issueService.issueBook(bookId, username);
        model.addAttribute("message", message);
        return "borrow";
    }

    @GetMapping("/return")
    public String returnPage() { return "return"; }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long bookId, @RequestParam String username, Model model) {
        String message = issueService.returnBook(bookId, username);
        model.addAttribute("message", message);
        return "return";
    }

    @GetMapping("/mybooks")
    public String listBorrowedBooks(@RequestParam String username, Model model) {
        List<IssueRecord> borrowedBooks = issueService.getBorrowedBooks(username);
        model.addAttribute("borrowedBooks", borrowedBooks);
        return "mybooks";
    }
}
