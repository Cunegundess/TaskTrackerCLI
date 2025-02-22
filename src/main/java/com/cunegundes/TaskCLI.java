package com.cunegundes;

import com.cunegundes.repository.TaskRepository;

public class TaskCLI {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();

        if (args.length < 1 ) {
            System.out.println("Usage: TaskCLI <command> [arguments]");
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2 ) {
                    System.out.println("Usage: TaskCLI add <description>");
                }
                taskRepository.addTask(args[1]);
                break;
        }
    }
}