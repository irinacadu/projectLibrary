package com.library.services;

import java.util.List;

import com.library.entities.User;

public interface IServiceUser {
    public List<User>getUsers();
    public User getUser(int idUser);
    public void save (User user);
    public void delete (int idUser);
    public void update (int idUser);
}
