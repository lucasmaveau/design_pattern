package com.fges.todoapp.presentation;


import com.fges.todoapp.comands.InsertCommand;
import com.fges.todoapp.commands.MigrateCommand;
import com.fges.todoapp.data.FileManager;
import com.fges.todoapp.data.FileManagerCsv;
import com.fges.todoapp.data.FileManagerJson;

import com.fges.todoapp.logic.OptionFactory;
import org.apache.commons.cli.*;

import java.io.IOException;

import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException {
        Options cliOptions = new Options();
        CommandLineParser parser = new DefaultParser();

        cliOptions.addOption(Option.builder("s").longOpt("source").hasArg().argName("file")
                .desc("Name of the source where the todo should be stored").required().build());
        cliOptions.addOption(Option.builder("d").longOpt("done").desc("Set the todo status as DONE").build());

        CommandLine cmd;
        try {
            cmd = parser.parse(cliOptions, args);
        } catch (ParseException ex) {
            System.err.println("Fail to parse arguments: " + ex.getMessage());
            return 1;
        }

        String sourceFileName = cmd.getOptionValue("source");
        boolean isDone = cmd.hasOption("d");
        String todoName = cmd.getArgs()[0]; // Get the todo name from positional arguments

        FileManager fileManager;
        if (sourceFileName.endsWith(".json")) {
            fileManager = new FileManagerJson(sourceFileName);
        } else if (sourceFileName.endsWith(".csv")) {
            fileManager = new FileManagerCsv(sourceFileName);
        } else {
            System.err.println("Unsupported source file extension");
            return 1;
        }

        commands.Command command = new InsertCommand(fileManager, todoName, isDone);
        command.execute();

        System.err.println("Insertion done.");
        return 0;
    }

}
