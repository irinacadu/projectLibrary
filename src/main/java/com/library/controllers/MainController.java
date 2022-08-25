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
import com.library.entities.Loan;
import com.library.entities.Opinion;
import com.library.entities.User;
import com.library.services.IServiceBook;
import com.library.services.IServiceLoan;
import com.library.services.IServiceOpinion;
import com.library.services.IServiceUser;
import com.library.services.OpinionServiceImpl;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private IServiceUser userService;

    @Autowired
    private IServiceLoan loanService;

    @Autowired
    private IServiceBook bookService;

    @Autowired
    IServiceOpinion opinionService;

    /* USER CONTROLLER */

    @GetMapping("/login")
    public String login(ModelMap model) {

        return "login";
    }

    @GetMapping("/userform")
    public String userForm(ModelMap map) {
        map.addAttribute("user", new User()); // se llama al objeto y lo crea vacío para poder rellenarlo
        // con los datos que le damos al darle de alta

        return "userform";

    }

    /* MÉTODO PARA COMPROBAR QUE LOS USUARIOS SE INCLUYEN EN LA BASE DE DATOS */
    @GetMapping("/userslist")
    public String getUsers(Model model) {
        model.addAttribute("userslist", userService.getUsers());
        return "userslist";
    }

    @PostMapping("/createuser")
    public String crearUser(@ModelAttribute(name = "user") User user,
            @RequestParam(name = "image", required = false) MultipartFile photo) {
        if (photo != null) {
            String rutaAbsoluta = "C://Users//icasasdu//Documents//recursos";
            Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + photo.getOriginalFilename());

            try {

                byte[] bytesFoto = photo.getBytes();
                Files.write(rutaCompleta, bytesFoto);
                user.setPhoto(photo.getOriginalFilename());
                userService.save(user);

            } catch (Exception e) {

                e.printStackTrace();

            }
        }

        return "redirect:/userslist";

    }

   @PostMapping("/createloan")
   public String creatLoan(@ModelAttribute(name = "loan")Loan loan){

    loanService.save(loan);

    return "redirect:/loanslist";

   }

    @GetMapping("/newloan/{id}")
    public ModelAndView newLoan(@PathVariable(name ="id") int id, Model model) {
        model.addAttribute("listaLibros", bookService.getBooks());
        User user = userService.getUser(id);
        Book book = bookService.getBook(id);

        ModelAndView mav = new ModelAndView();

         mav.setViewName("personalUsuarioProv");
         mav.addObject("user", user);
         mav.addObject("book", book);

         return mav;
     

    }

    @GetMapping("/detailsuser/{id}")
    public ModelAndView detailsUser(@PathVariable(name = "id") int id) {
        User user = userService.getUser(id);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("userdetails");
        mav.addObject("user", user);

        return mav;
    }

    
    @GetMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable(name = "id") int id) {
        User user = userService.getUser(id);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("userform");
        mav.addObject("user", user);

        return mav;

    }

    @GetMapping("/delete/{id}")
    public String deleteUSer(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return "redirect:/userslist";

    }

    /*******************************************************LOAN CONTROLLER ***************************************/
    @GetMapping("/loanform")
    public String loanform(ModelMap map) {

        return "loanform";

    }

    @GetMapping("/loanslist")
    public String getEstudiantes(Model model) {
        model.addAttribute("loanlist", loanService.getLoans());
        return "loanslist";
    }



    @GetMapping("/detailsloan/{id}")
    public ModelAndView detailsLoan(@PathVariable(name = "id") int id) {
        Loan loan = loanService.getLoan(id);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("loandetails");
        mav.addObject("loan", loan);
        
        return mav;
    }

    @GetMapping("/updateloan/{id}")
    public ModelAndView updateLoan(@PathVariable(name = "id") int id) {

        Loan loan = loanService.getLoan(id);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("loanform");
        mav.addObject("loan", loan);

        return mav;
    }

    // Funciona
    @GetMapping("/deleteloan/{id}")
    public String deleteLoan(@PathVariable(name = "id") int id) {

        loanService.delete(id);
        return "redirect:/loanslist";
    }

    //**************************************************+BOOK CONTROLLER************************************/

    @GetMapping("/catalogue")
    public String getBooks(Model model) {
        model.addAttribute("listaLibros", bookService.getBooks());

        return "books";
    }

    // @GetMapping("/formbook")
    // public String showFormulario(ModelMap map) {
    //     map.addAttribute("book", new Book());
    //     map.addAttribute("opinions", opinionService.getOpiniones());

    //     return "bookForm";
    // }

    // @GetMapping("/detailsbook/{id}")
    // public ModelAndView details(@PathVariable(name = "id") String id ) {

    //     Book book = bookService.getBook(Integer.parseInt(id));
    //     ModelAndView mav = new ModelAndView();

    //     mav.setViewName("bookDetail");
    //     mav.addObject("book", book);

    //     return mav;
    //  }

    //  @GetMapping("/updatebooks/{id}")
    //  public ModelAndView update(@PathVariable(name = "id") String id) {

    //     Book book = bookService.getBook(Integer.parseInt(id));
    //     List<Opinion> opinions = opinionService.getOpiniones();
    //     ModelAndView mav = new ModelAndView();
    //     mav.setViewName("uploadBook");
    //     mav.addObject("book", book);
    //     mav.addObject("opinion", opinions);

    //     return mav;
    //  }

    //  @PostMapping("/createbook")

    //  public String createBook(@ModelAttribute(name = "estudiante") Book book, 
    //  @RequestParam(name = "imagen", required = false) MultipartFile foto) {
 
    //      if (foto != null) {
    //          String rutaAbsoluta = "C://Users//mrubiolo//OneDrive - Capgemini//Documents//recursos";
    //          Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + foto.getOriginalFilename());
            
    //          try {
                 
    //              byte[] bytesFoto = foto.getBytes();
    //              Files.write(rutaCompleta, bytesFoto);
    //              book.setPhoto(foto.getOriginalFilename());
    //              bookService.save(book);
 
    //          } catch (Exception e) {
    //              e.printStackTrace();
    //          }
    //      }
    //      bookService.save(book);
    //      return "redirect:/catalogue";
    //  }

}
