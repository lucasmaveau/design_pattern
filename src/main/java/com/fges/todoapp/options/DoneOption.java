// DoneOption.java
package com.fges.todoapp.options;

import com.fges.todoapp.data.FileManager;

public class DoneOption implements Option {
    private final FileManager fileManager;

    public DoneOption(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void apply(String[] args) throws Exception {
        // Mettre en œuvre la logique spécifique à l'option --done
        // Par exemple, marquer une tâche comme terminée dans le gestionnaire de fichiers
    }
}
