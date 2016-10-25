package com.sfl.taskmanager.repository;

import com.sfl.taskmanager.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * User Repository interface
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByIsAdmin(boolean isAdmin);

}
