package com.fges.todoapp.logic;

import com.fges.todoapp.data.FileManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TaskManager {

    private final FileManager fileManager;
    private final boolean isDone;

    public TaskManager(FileManager fileManager, boolean isDone) {
        this.fileManager = fileManager;
        this.isDone = isDone;
    }

    public void executeCommand(String[] args) throws IOException {
        List<String> positionalArgs = Arrays.asList(args);
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return;
        }

        String task = positionalArgs.get(1);
        if (isDone) {
            task = "[Done] " + task;
        }

        fileManager.insertTask(task);

        String command = positionalArgs.get(0);

        if (command.equals("insert")) {
            insertTask(positionalArgs);
        }

        if (command.equals("list")) {
            listTasks();
        }
    }

    private void insertTask(List<String> positionalArgs) throws IOException {
        if (positionalArgs.size() < 2) {
            System.err.println("Missing TODO name");
            return;
        }
        String task = positionalArgs.get(1);

        fileManager.insertTask(task);
    }

    private void listTasks() throws IOException {
        String fileContent = fileManager.readContent();

        if (isDone) {
            listDoneTasks(fileContent);
        } else {
            fileManager.listTasks(fileContent);
        }
    }

    private void listDoneTasks(String fileContent) throws IOException {
        fileManager.listDoneTasks(fileContent);
    }
}
