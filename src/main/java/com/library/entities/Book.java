package com.library.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

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
//private String availability;
private String title;
private String author;
@Size(min = 1, max = 4000)
private String sinopsis;
private String photo;

@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE, mappedBy = "book")
private List<Opinion> opinions;

@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
private User user;

@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
private Genre genre;


    
}
