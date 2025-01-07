package org.example.todolist.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    // Getters
    public Long getId() {
        return id;
    }
    public Priority getPriority() {
        return priority;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}