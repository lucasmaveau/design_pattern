package com.fges.todoapp.commands;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
