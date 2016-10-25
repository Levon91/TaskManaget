package com.sfl.taskmanager.service.impl;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.User;
import com.sfl.taskmanager.repository.UserRepository;
import com.sfl.taskmanager.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;

/**
 * User service class
 */

@Service
public class UserService implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public User get(Long id) throws DatabaseException {
        try {
            return userRepository.findOne(id);
        } catch (RuntimeException e) {
            logger.error("Unable to get user by id : " + id, e);
            throw new DatabaseException("Unable to get user by id : " + id);
        }
    }

    public void add(User user) throws DatabaseException {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            throw new DatabaseException("Unable to add user");
        }
    }

    @Override
    public User findByEmail(String email) throws EntityNotFoundException, DatabaseException {
        try {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new EntityNotFoundException("User not found");
            }
            return user;
        } catch (RuntimeException e) {
            throw new DatabaseException("Unable to find user by email");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EntityNotFoundException, DatabaseException {
        try {
            User user = userRepository.findByEmail(email);
            if (user == null || !encoder.matches(password, user.getPassword())) {
                throw new EntityNotFoundException("User not found");
            }
            user.setPassword(null);
            return user;
        } catch (RuntimeException e) {
            throw new DatabaseException("Unable to find user by email");
        }
    }


    @Override
    public boolean isEmailExist(String email) throws DatabaseException {
        try {
            User user = userRepository.findByEmail(email);
            return user != null;
        } catch (RuntimeException e) {
            throw new DatabaseException("Unable to find user by email");
        }
    }

    @Override
    public List<User> getUsers() throws DatabaseException {
        try {
            return userRepository.findByIsAdmin(false);
        } catch (RuntimeException e) {
            throw new DatabaseException("Unable to find user by email");
        }
    }
}
