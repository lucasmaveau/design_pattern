package com.fges.todoapp.comands;

import com.fges.todoapp.data.FileManager;

import java.io.IOException;

public class ListCommand implements commands.Command {
    private final FileManager fileManager;
    private final boolean showDoneOnly;

    public ListCommand(FileManager fileManager, boolean showDoneOnly) {
        this.fileManager = fileManager;
        this.showDoneOnly = showDoneOnly;
    }

    @Override
    public void execute() throws IOException {
        String fileContent = fileManager.readContent();
        if (showDoneOnly) {
            fileManager.listDoneTasks(fileContent);
        } else {
            fileManager.listTasks(fileContent);
        }
    }
}
