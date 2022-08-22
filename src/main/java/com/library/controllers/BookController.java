package com.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.services.IServiceBook;

@Controller
@RequestMapping("/")
public class BookController {
    
    @Autowired
    IServiceBook bookService;

    @GetMapping("/catalogue")
    public String getBooks(Model model) {
        model.addAttribute("listaLibros", bookService.getBooks());

        return "books";
    }

}
