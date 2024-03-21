package com.fges.todoapp.comands;

import com.fges.todoapp.data.FileManager;

import java.io.IOException;

public class InsertCommand implements commands.Command {
    private final FileManager fileManager;
    private final String todoName;
    private final boolean isDone;

    public InsertCommand(FileManager fileManager, String todoName, boolean isDone) {
        this.fileManager = fileManager;
        this.todoName = todoName;
        this.isDone = isDone;
    }

    @Override
    public void execute() throws IOException {
        String task = isDone ? "[Done] " + todoName : todoName;
        fileManager.insertTask(task);
    }
}
