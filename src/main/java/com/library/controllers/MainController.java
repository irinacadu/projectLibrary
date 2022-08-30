package com.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entities.User;
import com.library.services.IServiceUser;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private IServiceUser userService;

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

    @GetMapping("/users")
    public String getEstudiantes(Model model) {



       model.addAttribute("users", userService.getUsers());



       return "users";
    }

@PostMapping("/createUser")
    public String crearEstudiante(@ModelAttribute(name = "user") User user
                                 /* @RequestParam(name = "imagen", required = false) MultipartFile fotito*/ ) {



    //    if (fotito != null){
    //         // Ruta absoluta donde se va a guardar la imagen (fotito)
    //         String rutaAbsoluta = "C://Users//eaviless//OneDrive - Capgemini//Documents//Recursos/";



    //        // Ruta completa (concatenar la ruta absoluta con el nombre de la imagen)
    //         Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + fotito.getOriginalFilename());    


//  try {
                // byte [] bytesFotito = fotito.getBytes();// esto coge los trozos y los almacena
                
                // Files.write(rutaCompleta, bytesFotito); //esto escribe el array de bytes en la ruta donde quiero guardar la img
                
                //estudiante.setFoto(fotito.getOriginalFilename());



               userService.save(user);



        //    } catch (IOException e) {
        //         e.printStackTrace();
        //     }



       

    return"redirect:/users"; // esto te devuelve el listado de estudiantes + nuevo estudiante creado
}

@GetMapping("/detailsuser/{id}")

public ModelAndView detailsUser(@PathVariable(name = "id") int id) {

    User user = userService.getUser(id);

    ModelAndView mav = new ModelAndView();



    mav.setViewName("userdetails");

    mav.addObject("user", user);



    return mav;

}

@GetMapping("/updateuser/{id}")

    public ModelAndView updateUser(@PathVariable(name = "id") int id) {

        User user = userService.getUser(id);

        ModelAndView mav = new ModelAndView();



        mav.setViewName("userReg");

        mav.addObject("user", user);



        return mav;



    }


}

