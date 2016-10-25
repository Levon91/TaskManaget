package com.sfl.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task")
@JsonIgnoreProperties({"user", "name"})
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @org.codehaus.jackson.annotate.JsonIgnore
    private User user;

    public Task() {
    }

    public Task(String name, String description, Project project, User user) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.user = user;
        this.status = Status.NEW;
    }

    public enum Status {
        NEW, DOING, DONE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
//
//    public Project getProject() {
//        return null;
//    }

    public void setProject(Project project) {
        this.project = project;
    }
//
//    public User getUser() {
//        return null;
//    }

    public void setUser(User user) {
        this.user = user;
    }
}
