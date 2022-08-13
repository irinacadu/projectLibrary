package com.library.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

public class Book {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id; 
private String availability;
private String title;
private String genre;
private String author;
private String sinopsis;
private String photo;


private String opinion;

@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
private User user;

@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
private Catalogue catalogue;

// @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "idBook")
// private Prestamo prestamo;

    
}
