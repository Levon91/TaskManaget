package com.sfl.taskmanager.repository;

import com.sfl.taskmanager.model.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Task Repository interface
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}
