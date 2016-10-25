package com.sfl.taskmanager.repository;

import com.sfl.taskmanager.model.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * Project Repository interface
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
