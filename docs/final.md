# Final Report

## Introduction

Ce rapport final présente une vue d'ensemble de notre projet de gestion de tâches TODO. Nous avons développé une application en ligne de commande (CLI) qui permet aux utilisateurs de gérer leurs tâches et de stocker les données dans différents types de sources de données. Nous avons également ajouté une fonctionnalité de démarrage d'un serveur web pour permettre l'accès aux tâches via une API REST.

## Structure du Projet

Le projet est organisé en plusieurs packages, chacun contenant des classes et des interfaces spécifiques. Voici la structure du projet :

### Commands

- **Command**: Interface de base pour toutes les commandes.
- **InsertCommand**: Commande pour insérer une nouvelle tâche.
- **ListCommand**: Commande pour lister les tâches.
- **MarkAsDoneCommand**: Commande pour marquer une tâche comme terminée.
- **MigrateCommand**: Commande pour migrer les tâches d'une source vers une autre.
- **WebCommand**: Commande pour démarrer un serveur web.

### Data

- **FileManager**: Interface pour la gestion des fichiers.
- **FileManagerCsv**: Implémentation de FileManager pour les fichiers CSV.
- **FileManagerJson**: Implémentation de FileManager pour les fichiers JSON.

### Logic

- **TaskManager**: Gère l'exécution des commandes et la manipulation des tâches.
- **OptionFactory**: Fabrique d'options pour créer et gérer les options des commandes.

### Options

- **DoneOption**: Option pour marquer une tâche comme terminée.
- **Option**: Interface de base pour toutes les options.
- **OptionsParser**: Parseur d'options pour interpréter les arguments de la ligne de commande.

### Presentation

- **App**: Classe principale pour lancer l'application et exécuter les commandes.

## How can a newcomer...

- **Add a new command**: Créez une nouvelle classe de commande dans le package `commands`, implémentez l'interface `Command`, et ajoutez-la à la méthode `exec()` dans `App.java`.

- **Add a new file-based datasource**: Créez une nouvelle implémentation de `FileManager` dans le package `data` et assurez-vous qu'elle peut lire et écrire des données à partir du nouveau type de source de données.

- **Add a non-file-based datasource**: Créez un nouveau service pour interagir avec la nouvelle source de données, puis intégrez ce service dans les commandes appropriées pour accéder et manipuler les données.

- **Add a new attribute to a Todo**: Modifiez la classe `TaskManager` pour inclure le nouvel attribut avec ses getters et setters, puis mettez à jour toutes les classes qui interagissent avec `TaskManager` pour prendre en compte le nouvel attribut.

- **Add a new interface to the project**: Créez une nouvelle interface dans le package approprié et assurez-vous que les classes qui doivent l'implémenter fournissent une implémentation appropriée de ses méthodes.

## Class Diagram

Veuillez trouver ci-dessous le diagramme de classes du projet.

![Class Diagram](final_diag.mmd)
