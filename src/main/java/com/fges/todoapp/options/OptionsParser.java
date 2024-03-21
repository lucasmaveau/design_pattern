package com.fges.todoapp.options;

import java.util.HashMap;
import java.util.Map;

public class OptionsParser {
    public Map<String, String> parseOptions(String[] args) {
        // Logique pour analyser les options de la ligne de commande et les stocker dans une Map
        // Exemple simplifié :
        Map<String, String> optionsMap = new HashMap<>();
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].startsWith("--")) {
                optionsMap.put(args[i].substring(2), args[i + 1]);
            }
        }
        return optionsMap;
    }
}
