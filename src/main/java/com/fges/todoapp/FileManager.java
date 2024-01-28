package com.fges.todoapp;
import java.io.IOException;

public interface FileManager {

    String lireContenuFichier() throws IOException;

    void ecrireDansFichier(String contenu) throws IOException;

    void insererTache(String tache) throws IOException;

    void listerTaches(String contenuFichier) throws IOException;
}
