package com.sfl.taskmanager.service.impl;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.Task;
import com.sfl.taskmanager.repository.TaskRepository;
import com.sfl.taskmanager.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Task service class
 */

@Service
public class TaskService implements ITaskService {

    private final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task get(Long id) throws DatabaseException {
        try {
            return taskRepository.findOne(id);
        } catch (RuntimeException e) {
            logger.error("Unable to get task by id : " + id, e);
            throw new DatabaseException("Unable to get task by id : " + id);
        }
    }

    public void add(Task task) throws DatabaseException {
        try {
            taskRepository.save(task);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            throw new DatabaseException("Unable to add task");
        }
    }

}
