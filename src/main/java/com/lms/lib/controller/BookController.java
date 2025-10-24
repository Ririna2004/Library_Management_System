package main.java.com.lms.lib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.java.com.lms.lib.domain.Book;
import main.java.com.lms.lib.service.BookService;

@Controller
public class BookController {
    @Autowired private BookService service;

    @GetMapping("welcome")
    public String viewHomePage(Model model) {
        model.addAttribute("listbook", service.listAll());
        return "welcome";
    }

    @GetMapping("new")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "new";
    }

    @PostMapping("save")
    public String saveBook(@ModelAttribute Book book) {
        service.save(book);
        return "redirect:/welcome";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("book", service.get(id));
        return "new";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable long id) {
        service.delete(id);
        return "redirect:/welcome";
    }

    @GetMapping("/logout")
    public String logout() { return "login"; }
}
