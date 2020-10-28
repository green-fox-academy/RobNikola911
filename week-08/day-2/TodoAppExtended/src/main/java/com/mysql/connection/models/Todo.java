package com.mysql.connection.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    private boolean urgent;
    private boolean done;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn
    private Assignee assignee;

    public Todo() {
    }

    public Todo(Long id, String title, String description, LocalDate creationDate, LocalDate dueDate, boolean urgent, boolean done, Assignee assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.urgent = urgent;
        this.done = done;
        this.assignee = assignee;
    }

    public Todo(String title, String description, LocalDate creationDate, LocalDate dueDate, boolean urgent, boolean done, Assignee assignee) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.urgent = urgent;
        this.done = done;
        this.assignee = assignee;
    }

    public Todo(String title, String description, LocalDate creationDate, LocalDate dueDate, Assignee assignee) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.urgent = false;
        this.done = false;
        this.assignee = assignee;
    }

    public Todo(String title, String description, LocalDate dueDate, boolean urgent, Assignee assignee) {
        this.title = title;
        this.description = description;
        this.creationDate = LocalDate.now();
        this.dueDate = dueDate;
        this.urgent = urgent;
        this.done = false;
        this.assignee = assignee;
    }

    public boolean isDone() {
        return done;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }
}
