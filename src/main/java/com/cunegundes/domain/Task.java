package com.cunegundes.domain;

import com.cunegundes.enums.TaskStatus;

import java.time.LocalDateTime;

public class Task {
    private static int lastId = 0;
    private final int id;
    private final String description;
    private TaskStatus status;
    private final LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public LocalDateTime getUpdatedTime() { return updatedTime;}

    public void markAsDone() { this.status = TaskStatus.DONE; }
    public void markAsInProgress() { this.status = TaskStatus.IN_PROGRESS; }
    public void markAsTodo() { this.status = TaskStatus.TODO; }
}
