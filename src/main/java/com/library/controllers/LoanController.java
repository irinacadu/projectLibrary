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

import com.library.entities.Loan;
import com.library.services.IServiceLoan;

@Controller
@RequestMapping("/loan")
public class LoanController {

    
    @Autowired
    private IServiceLoan loanService;
    
    @GetMapping("/loanform")
    public String loanform(ModelMap map) {

        return "loanform";

    }

    @GetMapping("/loanslist")
    public String getEstudiantes(Model model) {
        model.addAttribute("loanlist", loanService.getLoans());
        return "loanslist";
    }

    @PostMapping("/createloan")
    public String createLoan(@ModelAttribute(name="loan") Loan loan) {

        loanService.save(loan);
        return "redirect:/loansList";

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

}
