package com.fges.todoapp;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TaskManager {

    private final FileManager fileManager;

    public TaskManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void executerCommande(String[] args) throws IOException {
        List<String> positionalArgs = Arrays.asList(args);
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return;
        }

        String command = positionalArgs.get(0);

        if (command.equals("insert")) {
            insererTache(positionalArgs);
        }

        if (command.equals("list")) {
            listerTaches();
        }
    }

    private void insererTache(List<String> positionalArgs) throws IOException {
        if (positionalArgs.size() < 2) {
            System.err.println("Missing TODO name");
            return;
        }
        String tache = positionalArgs.get(1);

        fileManager.insererTache(tache);
    }

    private void listerTaches() throws IOException {
        String contenuFichier = fileManager.lireContenuFichier();
        fileManager.listerTaches(contenuFichier);
    }
}
