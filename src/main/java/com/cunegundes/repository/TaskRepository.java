package com.cunegundes.repository;

import com.cunegundes.domain.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class TaskRepository {
    private static final String FILE_NAME = "tasks.json";
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void markAsDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsDone();
                return;
            }
        }
    }

    public void markAsInProgress(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsInProgress();
                return;
            }
        }
    }

    public void markAsTodo(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsTodo();
                return;
            }
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        }
    }
}
