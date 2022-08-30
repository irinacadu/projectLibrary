package com.library.entities;

import java.util.Collection;



import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.ManyToMany;



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

public class Rol {

   

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;



   

    private int user_id;



   

    private String rol;






}