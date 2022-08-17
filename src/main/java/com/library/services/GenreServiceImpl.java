package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.IGenreDao;
import com.library.entities.Genre;

@Service
public class GenreServiceImpl implements IServiceGenre {

    @Autowired
    private IGenreDao genreDao;

    @Override
    public List<Genre> getGenres() {
        
        return genreDao.findAll();
    }

    @Override
    public Genre getGenre(int idGenre) {
        
        return genreDao.findById(idGenre).get();
    }

    @Override
    public void save(Genre genre) {
        genreDao.save(genre);

    }

    @Override
    public void delete(int idGenre) {
       genreDao.deleteById(idGenre);

    }

    @Override
    public void update(int idGenre) {
        // TODO Auto-generated method stub

    }

}
