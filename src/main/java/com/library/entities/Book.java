package com.library.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;



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
private boolean availability;
private String title;
private String author;
private String sinopsis;
private String photo;


@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
private User user;

@ManyToOne
private Genre genre;


    
}
