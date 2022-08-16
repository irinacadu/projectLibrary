package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.IUserDao;
import com.library.entities.User;

@Service
public class UserServiceImpl implements IServiceUser {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> getUsers() {
        
        return userDao.findAll();
    }

    @Override
    public User getUser(int idUser) {
        // TODO Auto-generated method stub
        return userDao.findById(idUser).get();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
        
    }

    @Override
    public void delete(int idUser) {
        userDao.deleteById(idUser);
        
    }

    @Override
    public void update(int idUser) {
        // TODO Auto-generated method stub
        
    }
    
}
