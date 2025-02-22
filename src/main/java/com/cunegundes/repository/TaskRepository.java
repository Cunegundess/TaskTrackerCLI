package com.cunegundes.repository;

import com.cunegundes.domain.Task;
import com.cunegundes.enums.TaskStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static final String FILE_NAME = "tasks.json";
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
    }

    public void updateTask(int id, String description) {

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
        JSONArray jsonArray = new JSONArray();
        for (Task task : getTasks()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", task.getId());
            jsonObject.put("description", task.getDescription());
            jsonObject.put("status", task.getStatus().toString());
            jsonObject.put("createdTime", task.getCreatedTime().toString());
            jsonObject.put("updatedTime", task.getUpdatedTime().toString());

            jsonArray.add(jsonObject);
        }

        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);
                Task task = new Task(
                        (Integer) obj.get("id"),
                        obj.get("title").toString(),
                        obj.get("description").toString(),
                        TaskStatus.valueOf(obj.get("status").toString()),
                        LocalDateTime.parse(obj.get("createdTime").toString()),
                        LocalDateTime.parse(obj.get("updatedTime").toString())
                );
                addTask(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
