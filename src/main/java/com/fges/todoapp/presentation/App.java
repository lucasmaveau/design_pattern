package com.fges.todoapp.presentation;


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
                .desc("File containing the todos").required().build());
        cliOptions.addOption(Option.builder("o").longOpt("output").hasArg().argName("file")
                .desc("Output file for migration").required().build());

        cliOptions.addOption("d", "done", false, "Mark task as done");

        CommandLine cmd;
        try {
            cmd = parser.parse(cliOptions, args);
        } catch (ParseException ex) {
            System.err.println("Fail to parse arguments: " + ex.getMessage());
            return 1;
        }

        String sourceFileName = cmd.getOptionValue("source");
        String outputFileName = cmd.getOptionValue("output");

        FileManager sourceFileManager;
        if (sourceFileName.endsWith(".json")) {
            sourceFileManager = new FileManagerJson(sourceFileName);
        } else if (sourceFileName.endsWith(".csv")) {
            sourceFileManager = new FileManagerCsv(sourceFileName);
        } else {
            System.err.println("Unsupported source file extension");
            return 1;
        }

        FileManager outputFileManager;
        if (outputFileName.endsWith(".json")) {
            outputFileManager = new FileManagerJson(outputFileName);
        } else if (outputFileName.endsWith(".csv")) {
            outputFileManager = new FileManagerCsv(outputFileName);
        } else {
            System.err.println("Unsupported output file extension");
            return 1;
        }

        Map<String, com.fges.todoapp.options.Option> options = OptionFactory.createOptions(sourceFileManager);
        commands.Command command = new MigrateCommand(sourceFileManager, outputFileManager);
        command.execute();

        System.err.println("Migration done.");
        return 0;
    }
}
