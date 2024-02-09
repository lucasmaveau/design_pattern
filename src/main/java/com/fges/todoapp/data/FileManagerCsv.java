package com.fges.todoapp.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileManagerCsv implements FileManager {

    private final Path filePath;

    public FileManagerCsv(String fileName) {
        this.filePath = Path.of(fileName);
    }

    @Override
    public String readContent() throws IOException {
        return Files.exists(filePath) ? Files.readString(filePath) : "";
    }

    @Override
    public void writeContent(String content) throws IOException {
        Files.writeString(filePath, content);
    }

    @Override
    public void insertTask(String task) throws IOException {
        String fileContent = readContent();
        if (!fileContent.endsWith("\n") && !fileContent.isEmpty()) {
            fileContent += "\n";
        }
        fileContent += task;
        writeContent(fileContent);
    }

    @Override
    public void listTasks(String fileContent) {
        System.out.println(
                String.join("\n",
                        Arrays.stream(fileContent.split("\n"))
                                .map(task -> "- " + task)
                                .collect(Collectors.toList())
                )
        );
    }

    @Override
    public void listDoneTasks(String fileContent) {
        Arrays.stream(fileContent.split("\n"))
                .filter(task -> task.startsWith("[Done]"))
                .forEach(task -> System.out.println("- " + task));
    }
}
