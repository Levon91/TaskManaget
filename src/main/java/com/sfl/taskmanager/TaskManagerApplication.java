package com.sfl.taskmanager;

import com.sfl.taskmanager.model.Project;
import com.sfl.taskmanager.model.Task;
import com.sfl.taskmanager.model.User;
import com.sfl.taskmanager.service.IProjectService;
import com.sfl.taskmanager.service.ITaskService;
import com.sfl.taskmanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {

    @Autowired
    private IUserService userService;
    @Autowired
    private ITaskService taskService;
    @Autowired
    private IProjectService projectService;

    public static void main(String[] args) {

//		new SpringApplicationBuilder()
//				.sources(UserManagementApplication.class)
//				.bannerMode(Banner.Mode.OFF)
//				.run(args);
        SpringApplication.run(TaskManagerApplication.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        userService.add(new User("Admin", "Administrator", true, "admin@mail.ru", "admin"));
        User user = new User("User", "User", false, "user@mail.ru", "user");
        userService.add(user);
        Project project = new Project("Task Manager", "Simple task manager");
        projectService.add(project);
        taskService.add(new Task("Database implementation", "Create appropriate tables for Task manager project", project, user));
        taskService.add(new Task("Login implementation", "Create login page", project, user));
    }
}
