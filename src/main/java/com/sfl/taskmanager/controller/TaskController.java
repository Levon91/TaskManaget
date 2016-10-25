package com.sfl.taskmanager.controller;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.ResponseDTO;
import com.sfl.taskmanager.model.Task;
import com.sfl.taskmanager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @Secured(value = "ADMIN")
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO create(@RequestBody Task task) {
        try {
            taskService.add(task);
        } catch (DatabaseException e) {
            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
        return new ResponseDTO(HttpStatus.CREATED, "success");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTask(@PathVariable(value = "id") Long id) {
        Task task;
        try {
            task = taskService.get(id);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(task, OK);
    }

}
