package com.library.services;

import java.util.List;

import com.library.entities.Opinion;

public interface IServiceOpinion {
    public List<Opinion>getOpiniones();
    public Opinion getOpinion (int idOpinion);
    public void save (Opinion opinion);
    public void delete (int idOpinion);
    public void update (int idOpinion);
}
