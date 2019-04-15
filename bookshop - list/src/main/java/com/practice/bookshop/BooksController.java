package com.practice.bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/all")
    public String showAll(Model model) {
        model.addAttribute("books", bookService.findAll());

        return "allBooks";
    }

}
