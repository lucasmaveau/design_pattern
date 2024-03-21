package com.fges.todoapp.comands;

import com.fges.todoapp.data.FileManager;

import java.io.IOException;

public class MarkAsDoneCommand implements commands.Command {
    private final FileManager fileManager;
    private final String task;

    public MarkAsDoneCommand(FileManager fileManager, String task) {
        this.fileManager = fileManager;
        this.task = task;
    }

    @Override
    public void execute() {
        try {
            fileManager.insertTask("[Done] " + task);
            System.out.println("Task marked as done: " + task);
        } catch (IOException e) {
            System.err.println("Error marking task as done: " + e.getMessage());
        }
    }
}
