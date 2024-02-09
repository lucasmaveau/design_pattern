package com.fges.todoapp.presentation;

import com.fges.todoapp.data.FileManager;
import com.fges.todoapp.data.FileManagerCsv;
import com.fges.todoapp.data.FileManagerJson;
import com.fges.todoapp.logic.TaskManager;
import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    /**
     * Do not change this method
     */
    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException {
        Options cliOptions = new Options();
        CommandLineParser parser = new DefaultParser();

        cliOptions.addRequiredOption("s", "source", true, "File containing the todos");

        CommandLine cmd;
        try {
            cmd = parser.parse(cliOptions, args);
        } catch (ParseException ex) {
            System.err.println("Fail to parse arguments: " + ex.getMessage());
            return 1;
        }

        String fileName = cmd.getOptionValue("s");

        FileManager fileManager;
        if (fileName.endsWith(".json")) {
            fileManager = new FileManagerJson(fileName);
        } else if (fileName.endsWith(".csv")) {
            fileManager = new FileManagerCsv(fileName);
        } else {
            System.err.println("Unsupported file extension");
            return 1;
        }

        boolean isDone = cmd.hasOption("d");

        TaskManager taskManager = new TaskManager(fileManager, isDone);
        taskManager.executeCommand(cmd.getArgs());

        System.err.println("Done.");
        return 0;
    }
}
