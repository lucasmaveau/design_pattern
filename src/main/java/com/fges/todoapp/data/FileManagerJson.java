package com.fges.todoapp.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManagerJson implements FileManager {

    private final Path filePath;

    public FileManagerJson(String fileName) {
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
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(fileContent);
        if (actualObj instanceof MissingNode) {
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.add(task);
        }
        writeContent(actualObj.toString());
    }

    @Override
    public void listTasks(String fileContent) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(fileContent);
        if (actualObj instanceof MissingNode) {
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> System.out.println("- " + node.toString()));
        }
    }

    @Override
    public void listDoneTasks(String fileContent) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(fileContent);
        if (actualObj instanceof MissingNode) {
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> {
                if (node.toString().startsWith("[Done]")) {
                    System.out.println("- " + node.toString());
                }
            });
        }
    }
}