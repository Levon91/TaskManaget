package com.sfl.taskmanager.service;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.Task;

public interface ITaskService {

    Task get(Long id) throws DatabaseException;

    void add(Task Task) throws DatabaseException;
}
