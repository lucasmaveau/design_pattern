package com.fges.todoapp.logic;

import com.fges.todoapp.data.FileManager;
import com.fges.todoapp.options.Option;
import com.fges.todoapp.options.OptionsParser;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private final FileManager fileManager;
    private final Map<String, Option> options;

    public TaskManager(FileManager fileManager, Map<String, Option> options) {
        this.fileManager = fileManager;
        this.options = options;
    }

    public void executeCommand(String[] args) throws Exception {
        // Analyse des options
        OptionsParser optionsParser = new OptionsParser();
        String optionKey = optionsParser.parseOptions(args).toString();

        // Exécution de l'option si présente
        if (optionKey != null && options.containsKey(optionKey)) {
            options.get(optionKey).apply(args);
            return;
        }

        // Traitement par défaut
        List<String> positionalArgs = Arrays.asList(args);
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return;
        }

        String task = positionalArgs.get(1);
        if (options.containsKey("done")) {
            task = "[Done] " + task;
        }

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

        if (options.containsKey("done")) {
            listDoneTasks(fileContent);
        } else {
            fileManager.listTasks(fileContent);
        }
    }

    private void listDoneTasks(String fileContent) throws IOException {
        fileManager.listDoneTasks(fileContent);
    }
}
