package models;

import java.time.LocalDateTime;

public class Task {
    Long id;
    String name;
    String description;
    LocalDateTime deadline;
    String category;
    boolean completed = false;

    // Constructors
    public Task() {
    }

    public Task(Long id) {
        this.id = id;
    }

    public Task(Long id, String name, String description, LocalDateTime deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }

    public Task(Long id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Task(Long id, String name, String description, LocalDateTime deadline, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.category = category;
    }

    // Getters and setters
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

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
