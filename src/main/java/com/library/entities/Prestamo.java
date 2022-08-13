package com.library.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

public class Prestamo {

    private int id;
    private LocalDate deliveryDate;
    private LocalDate dueDate;


   // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "prestamo")
//    @ManyToMany
//     private Book idBook;

    // @ManyToOne
    // private User idUser;

}
