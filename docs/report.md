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


03/02

Organisation dans les packages : 

src/

|-- presentation/

|   |-- App.java

|

|-- logic/

|   |-- TaskManager.java

|

|-- data/

|   |-- FileManager.java

|   |-- FileManagerJson.java

|   |-- FileManagerCsv.java


J'ai décidé donc d'organiser mes packages comme ci dessus et j'ai rajouté des méthodes listerTachesTerminer afin de différencier une tache terminé ou non et de pouvoir les traiter : 

# Ajouter une tâche terminée
./exec.sh insert "I am done" -d -s file.json

# Ajouter une tâche non terminée
./exec.sh insert "I am not done" -s file.json

# Liste de toutes les tâches
./exec.sh list -s file.json
# Done: I am done
# I am not done

# Liste des tâches terminées uniquement
./exec.sh list -s file.json --done
# Done: I am done
