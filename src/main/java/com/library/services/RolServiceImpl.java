package com.library.services;





import java.util.Collection;

import java.util.List;



import javax.persistence.CascadeType;

import javax.persistence.FetchType;

import javax.persistence.ManyToMany;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.library.dao.IRolDao;

import com.library.entities.Rol;

import com.library.entities.User;



@Service

public class RolServiceImpl implements IServiceRol{



   

    @Autowired

    private IRolDao rolDao;



    @Override

    public Rol getRol(int idRol) {

        return rolDao.findById(idRol).get();

    }

     

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    private Collection<User> users;



    @Override

    public void save(Rol rol) {

      rolDao.save(rol);

       

    }



    @Override

    public List<Rol> getRols() {

           return rolDao.findAll();

     

    }

   

}