package com.library.entities;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


public class Opinion {

    private int id;    
    private String opinion;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST )
    private Book idBook;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST )
    private User idUser;


    
}
