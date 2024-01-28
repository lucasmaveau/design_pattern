package com.fges.todoapp;

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
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(contenuFichier);
        if (actualObj instanceof MissingNode) {
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.add(tache);
        }
        ecrireDansFichier(actualObj.toString());
    }

    @Override
    public void listerTaches(String contenuFichier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(contenuFichier);
        if (actualObj instanceof MissingNode) {
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> System.out.println("- " + node.toString()));
        }
    }
}
