package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.IPrestamoDao;
import com.library.entities.Prestamo;

@Service
public class PrestamoServiceImpl implements IServicePrestamo {

    @Autowired
    private IPrestamoDao prestamoDao;

    @Override
    public List<Prestamo> getPrestamos() {
       
        return prestamoDao.findAll();
    }

    @Override
    public Prestamo getPrestamo(int idPrestamo) {
    
        return prestamoDao.findById(idPrestamo).get();
    }

    @Override
    public void save(Prestamo prestamo) {
        prestamoDao.save(prestamo);    
    }

    @Override
    public void delete(int idPrestamo) {
        prestamoDao.deleteById(idPrestamo);
        
    }

    @Override
    public void update(int idPrestamo) {
       
        
    }
    
}
