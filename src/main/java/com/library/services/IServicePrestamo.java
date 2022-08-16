package com.library.services;

import java.util.List;

import com.library.entities.Prestamo;

public interface IServicePrestamo {
    public List<Prestamo>getPrestamos();
    public Prestamo getPrestamo(int idPrestamo);
    public void save (Prestamo prestamo);
    public void delete (int idPrestamo);
    public void update (int idPrestamo);
}
