package com.fges.todoapp.logic;

import com.fges.todoapp.data.FileManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TaskManager {

    private final FileManager fileManager;
    private final boolean isDone;

    public TaskManager(FileManager fileManager, boolean isDone) {
        this.fileManager = fileManager;
        this.isDone = isDone;
    }

    public void executerCommande(String[] args) throws IOException {
        List<String> positionalArgs = Arrays.asList(args);
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return;
        }

        String tache = positionalArgs.get(1);
        if (isDone) {
            tache = "[Done] " + tache;
        }

        fileManager.insererTache(tache);

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

        if (isDone) {
            listerTachesTermines(contenuFichier);
        } else {
            fileManager.listerTaches(contenuFichier);
        }

        fileManager.listerTaches(contenuFichier);
    }

    private void listerTachesTermines(String contenuFichier) throws IOException {
        fileManager.listerTachesTermines(contenuFichier);
    }
}
