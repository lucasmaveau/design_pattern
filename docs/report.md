# L3 design pattern report

- **Firstname**: Lucas
- **Lastname**: Maveau

28/01
Ajout des classes : 

- TaskManager
- FileManager
    - FileManagerCsv
    - FileManagerJson

La classe App donc gère le démarrage de l'application, analyse les arguments de la ligne de commande, et délègue l'exécution des commandes à la classe TaskManager.

La classe TaskManager gère les opérations liées aux tâches (insertion, listing) et utilise un objet de type GestionnaireDeFichier pour lire/écrire les données en fonction du type de fichier spécifié.

De ce fait, la classe File Manager est une interface qui définit les opérations de base pour la manipulation de fichiers, avec des implémentations spécifiques pour les fichiers : FileManagerCsv et FileManagerJson qui implémente les commandes en fonction du fichier.

---
...
