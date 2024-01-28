package com.fges.todoapp;

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
    public String lireContenuFichier() throws IOException {
        return Files.exists(filePath) ? Files.readString(filePath) : "";
    }

    @Override
    public void ecrireDansFichier(String contenu) throws IOException {
        Files.writeString(filePath, contenu);
    }

    @Override
    public void insererTache(String tache) throws IOException {
        String contenuFichier = lireContenuFichier();
        if (!contenuFichier.endsWith("\n") && !contenuFichier.isEmpty()) {
            contenuFichier += "\n";
        }
        contenuFichier += tache;
        ecrireDansFichier(contenuFichier);
    }

    @Override
    public void listerTaches(String contenuFichier) {
        System.out.println(
                String.join("\n",
                        Arrays.stream(contenuFichier.split("\n"))
                                .map(tache -> "- " + tache)
                                .collect(Collectors.toList())
                )
        );
    }
}
