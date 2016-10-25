package com.sfl.taskmanager.service;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.User;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;


public interface IUserService {

    User get(Long id) throws DatabaseException;

    void add(User user) throws DatabaseException;

    User findByEmail(String email) throws EntityNotFoundException, DatabaseException;

    User findByEmailAndPassword(String email, String password) throws EntityNotFoundException, DatabaseException;

    boolean isEmailExist(String email) throws DatabaseException;

    List<User> getUsers() throws DatabaseException;

}
