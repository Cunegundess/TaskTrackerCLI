package com.cunegundes.domain;

import com.cunegundes.enums.TaskStatus;

import java.time.LocalDateTime;

public class Task {
    private final int id;
    private final String title;
    private final String description;
    private TaskStatus status;
    private final LocalDateTime createdTime;
    private final LocalDateTime updatedTime;

    Task(int id, String title, String description, TaskStatus status, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public LocalDateTime getUpdatedTime() { return updatedTime;}

    public void markAsDone() { this.status = TaskStatus.DONE; }
    public void markAsInProgress() { this.status = TaskStatus.IN_PROGRESS; }
    public void markAsTodo() { this.status = TaskStatus.TODO; }
}
