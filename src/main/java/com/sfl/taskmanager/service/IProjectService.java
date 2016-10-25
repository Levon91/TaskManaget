package com.sfl.taskmanager.service;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.Project;

public interface IProjectService {


    Project get(Long id) throws DatabaseException;

    void add(Project project) throws DatabaseException;

}
