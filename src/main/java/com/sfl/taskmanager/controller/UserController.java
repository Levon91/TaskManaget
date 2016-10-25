package com.sfl.taskmanager.controller;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.ResponseDTO;
import com.sfl.taskmanager.model.User;
import com.sfl.taskmanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        try {
            return new ResponseEntity<>(userService.getUsers(), OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @Secured(value = "ADMIN")
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO create(@RequestBody User user) {
        try {
            user.setAdmin(false);
            userService.add(user);
        } catch (DatabaseException e) {
            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
        return new ResponseDTO(HttpStatus.CREATED, "success");
    }

    @RequestMapping(value = "/exist/{email}", method = RequestMethod.POST)
    public ResponseDTO isEmailExist(@PathVariable String email) {
        try {
            return userService.isEmailExist(email) ?
                    new ResponseDTO(OK) :
                    new ResponseDTO(HttpStatus.NOT_FOUND);
        } catch (DatabaseException e) {
            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
        User user;
        try {
            user = userService.get(id);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(user, OK);
    }

    @RequestMapping(value = "/me", method = RequestMethod.POST)
    public ResponseEntity<User> getUserByEmailPassword(@RequestParam(value = "email") String email,
                                                       @RequestParam(value = "password") String password) {
        User user;
        try {
            user = userService.findByEmailAndPassword(email, password);
        } catch (Exception e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(user, OK);
    }


}
