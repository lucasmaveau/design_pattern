package com.fges.todoapp.data;

import java.io.IOException;

public interface ListManager {
    void listTasks(String fileContent) throws IOException;
    void listCompletedTasks(String fileContent) throws IOException;
}
