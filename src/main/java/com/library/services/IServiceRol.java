package com.library.services;





import java.util.List;



import com.library.entities.Rol;



public interface IServiceRol {

   

    public Rol getRol(int idRol);

   

 public void save (Rol rol);



     public List<Rol>getRols();

}