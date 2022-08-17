package com.library.services;

import java.util.List;

import com.library.entities.Genre;

public interface IServiceGenre {

    public List<Genre>getGenres();
    public Genre getGenre(int idGenre);
    public void save (Genre genre);
    public void delete (int idGenre);
    public void update (int idGenre);
    
}
