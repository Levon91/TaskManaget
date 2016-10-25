package com.sfl.taskmanager.controller;

import com.sfl.taskmanager.exception.DatabaseException;
import com.sfl.taskmanager.model.Project;
import com.sfl.taskmanager.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @Secured(value = "ADMIN")
    @RequestMapping(method = POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody Project project) {
        try {
            projectService.add(project);
        } catch (DatabaseException e) {
            return new ResponseEntity(INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(CREATED);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Project> getTask(@PathVariable(value = "id") Long id) {
        Project project;
        try {
            project = projectService.get(id);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(project, OK);
    }

}
