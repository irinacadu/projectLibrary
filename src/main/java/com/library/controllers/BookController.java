package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entities.Book;
import com.library.entities.Opinion;
import com.library.services.IServiceBook;
import com.library.services.IServiceOpinion;

@Controller
@RequestMapping("/")
public class BookController {
    
    @Autowired
    IServiceBook bookService;

    @Autowired
    IServiceOpinion opinionService;

    @GetMapping("/catalogue")
    public String getBooks(Model model) {
        model.addAttribute("listaLibros", bookService.getBooks());

        return "books";
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable(name = "id") String id ) {

        Book book = bookService.getBook(Integer.parseInt(id));
        ModelAndView mav = new ModelAndView();

        mav.setViewName("bookDetail");
        mav.addObject("book", book);

        return mav;
     }

     @GetMapping("/update/{id}")
     public ModelAndView update(@PathVariable(name = "id") String id) {

        Book book = bookService.getBook(Integer.parseInt(id));
        List<Opinion> opinions = opinionService.getOpiniones();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("uploadBook");
        mav.addObject("book", book);
        mav.addObject("opinion", opinions);

        return mav;
     }
     

}
