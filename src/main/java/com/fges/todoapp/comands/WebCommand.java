package com.fges.todoapp.comands;

import com.fges.todoapp.data.FileManager;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebCommand implements commands.Command {
    private final FileManager fileManager;

    public WebCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        com.fges.todoapp.web.TodoHandler todoHandler = new com.fges.todoapp.web.TodoHandler(fileManager);
        server.createContext("/todos", todoHandler);
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080...");
    }
}
