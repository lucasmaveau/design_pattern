package com.fges.todoapp.commands;

import com.fges.todoapp.data.FileManager;

import java.io.IOException;

public class MigrateCommand implements Command {
    private final FileManager sourceFileManager;
    private final FileManager outputFileManager;

    public MigrateCommand(FileManager sourceFileManager, FileManager outputFileManager) {
        this.sourceFileManager = sourceFileManager;
        this.outputFileManager = outputFileManager;
    }

    @Override
    public void execute() throws IOException {
        String sourceContent = sourceFileManager.readContent();
        outputFileManager.insertTask(sourceContent);
    }
}
