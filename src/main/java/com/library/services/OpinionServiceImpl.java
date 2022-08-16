package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.IOpinionDao;
import com.library.entities.Opinion;

@Service
public class OpinionServiceImpl implements IServiceOpinion {

    @Autowired
    private IOpinionDao opinionDao;


    @Override
    public List<Opinion> getOpiniones() {
     
        return opinionDao.findAll();
    }

    @Override
    public Opinion getOpinion(int idOpinion) {
      
    
        return opinionDao.findById(idOpinion).get();
    }

    @Override
    public void save(Opinion opinion) {
        opinionDao.save(opinion);
        
    }

    @Override
    public void delete(int idOpinion) {
        opinionDao.deleteById(idOpinion);
        
    }

    @Override
    public void update(int idOpinion) {
        // TODO Auto-generated method stub
        
    }

  
      

    
}
