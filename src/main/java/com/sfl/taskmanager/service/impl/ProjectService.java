package com.sfl.taskmanager.service.impl;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.Project;
import com.sfl.taskmanager.repository.ProjectRepository;
import com.sfl.taskmanager.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project service class
 */

@Service
public class ProjectService implements IProjectService {

    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project get(Long id) throws DatabaseException {
        try {
            return projectRepository.findOne(id);
        } catch (RuntimeException e) {
            logger.error("Unable to get project by id : " + id, e);
            throw new DatabaseException("Unable to get project by id : " + id);
        }
    }

    public void add(Project project) throws DatabaseException {
        try {
            projectRepository.save(project);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            throw new DatabaseException("Unable to add project.");
        }
    }

}
