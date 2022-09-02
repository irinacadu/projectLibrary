package com.library.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
   // @Size(min=2 , max =30, message="La longitud del nombre debe estar entre 2 y 3 caracteres")
    private String name;

    @NotEmpty
    //@Size(min=8, max=40, message = "La longitud de los apellidos debe estar entre 8 y 40 caracteres")
    private String surname;

    @NotEmpty
   // @Size(min=10, max=50 , message="La longitud del mail debe estar entre 10 y 50 caracteres")
    @Email
    private String email;

    @NotEmpty
   // @Size(min=9, max=13, message="La longitud del telefono no es correcta.")
    private String phone;

    private String photo;

  
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotEmpty
   // @Size(min=5,max=15, message= "La longitud del nombre de usuario debe estar entre 5 y 15 caracteres")
    private String userName; 


    @NotEmpty
   // @Size(min=8,max=15, message= "La longitud del nombre de usuario debe estar entre 8 y 15 caracteres")
   // @NotBlank(message="La contraseña  no puede estar vacía")     
    //@Pattern(regexp="^[0-9]{1,2}$",message="Edad incorrecta")    
    private String password;


    // ESTA RELACION DA ERROR
    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "user")
    // private List<Opinion> opinion;


    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "user")
    // private List<Book> book;

    // ESTA DA ERROR
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "user")
    private List<Loan> prestamoPrestador;
    
    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "user2")
    // private List<Loan> prestamoPrestado;
    
}
