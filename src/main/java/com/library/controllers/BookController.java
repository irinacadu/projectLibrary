package com.library.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    @GetMapping("/formulario")
    public String showFormulario(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("opinions", opinionService.getOpiniones());

        return "bookForm";
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
        mav.setViewName("bookForm");
        mav.addObject("book", book);
        mav.addObject("opinion", opinions);

        return mav;
     }

     @PostMapping("/createBook")
     public String createBook(@ModelAttribute(name = "estudiante") Book book, 
     @RequestParam(name = "imagen", required = false) MultipartFile foto) {
 
         if (foto != null) {
             String rutaAbsoluta = "C://Users//mrubiolo//OneDrive - Capgemini//Documents//recursos";
             Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + foto.getOriginalFilename());
            
             try {
                 
                 byte[] bytesFoto = foto.getBytes();
                 Files.write(rutaCompleta, bytesFoto);
                 book.setPhoto(foto.getOriginalFilename());
                 bookService.save(book);
 
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         bookService.save(book);
         return "redirect:/catalogue";
     }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable(name = "id") String id) {

        bookService.delete(Integer.parseInt(id));

        return "redirect:/catalogue";

    }

}
