# Final Report

## Introduction

Ce rapport final présente une vue d'ensemble de notre projet de gestion de tâches TODO. Nous avons développé une application en ligne de commande (CLI) qui permet aux utilisateurs de gérer leurs tâches et de stocker les données dans différents types de sources de données. Nous avons également ajouté une fonctionnalité de démarrage d'un serveur web pour permettre l'accès aux tâches via une API REST.

## A new command

Pour ajouter une nouvelle commande à l'application, un nouveau fichier de commande doit être créé dans le package `commands`. Ce fichier doit implémenter l'interface `Command` et fournir une implémentation de la méthode `execute()` pour exécuter la logique de la commande. Ensuite, la nouvelle commande doit être intégrée dans la méthode `exec()` de la classe `App.java` pour être exécutée à partir de la ligne de commande.

## A new file-based datasource

Pour ajouter une nouvelle source de données basée sur un fichier, un nouveau gestionnaire de fichiers doit être créé dans le package `data`. Ce gestionnaire de fichiers doit implémenter l'interface `FileManager` pour fournir des méthodes pour lire, écrire et manipuler les données dans le fichier. Ensuite, le nouveau gestionnaire de fichiers doit être intégré dans la méthode `exec()` de la classe `App.java` pour être utilisé par les commandes qui nécessitent un accès à la source de données.

## A non-file-based datasource

Pour ajouter une nouvelle source de données non basée sur un fichier, un nouveau service doit être créé dans le package `service`. Ce service doit fournir des méthodes pour interagir avec la source de données non basée sur un fichier, qu'il s'agisse d'une base de données, d'une API web, ou autre. Ensuite, le nouveau service doit être utilisé par les commandes appropriées pour accéder et manipuler les données à partir de la source de données.

## A new attribute to a Todo

Pour ajouter un nouvel attribut à une tâche TODO, la classe `Todo.java` doit être modifiée pour inclure le nouvel attribut avec ses getters et setters correspondants. Ensuite, toutes les classes qui interagissent avec la classe `Todo` doivent être mises à jour pour prendre en compte le nouvel attribut, en particulier les commandes qui lisent et écrivent des tâches TODO.

## A new interface to the project

Pour ajouter une nouvelle interface au projet, une nouvelle interface Java doit être créée dans le package approprié en fonction du contexte de son utilisation. Par exemple, si l'interface est destinée à être utilisée par les gestionnaires de fichiers, elle peut être placée dans le package `data`. Ensuite, les classes qui doivent implémenter cette interface doivent être mises à jour pour fournir une implémentation appropriée de ses méthodes.

## Class Diagram

Veuillez trouver dans le repertoire docs, les diagrammes.


LUCAS MAVEAU 
L3 SDN