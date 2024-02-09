package com.fges.todoapp.data;

import java.io.IOException;

public interface FileManager {

    String readContent() throws IOException;

    void writeContent(String content) throws IOException;

    void insertTask(String task) throws IOException;

    void listTasks(String fileContent) throws IOException;

    void listDoneTasks(String fileContent) throws IOException;
}
