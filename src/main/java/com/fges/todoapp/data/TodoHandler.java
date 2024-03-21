package com.fges.todoapp.web;

import com.fges.todoapp.data.FileManager;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class TodoHandler implements HttpHandler {
    private final FileManager fileManager;

    public TodoHandler(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Gérer les requêtes POST et GET ici pour créer et lister les todos
    }
}
