package com.fges.todoapp.logic;

import com.fges.todoapp.data.FileManager;
import com.fges.todoapp.options.DoneOption;
import com.fges.todoapp.options.Option;

import java.util.HashMap;
import java.util.Map;

public class OptionFactory {
    public static Map<String, Option> createOptions(FileManager fileManager) {
        Map<String, Option> options = new HashMap<>();
        options.put("--done", new DoneOption(fileManager));
        return options;
    }
}
