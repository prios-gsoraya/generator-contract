# 📄 Générateur de Contrats Swagger

Bienvenue dans le projet **Générateur de Contrats Swagger** ! Ce projet vous permet de générer des contrats Swagger en
format YAML pour vos entités via un formulaire simple sur une interface web. Le fichier YAML généré est organisé dans
des sous-dossiers basés sur le nom de l'entité.

---

## 🚀 Fonctionnalités

- **Génération de contrats Swagger** au format YAML pour vos entités.
- **Formulaire web** interactif permettant de spécifier le nom de l'entité et une description.
- **Téléchargement automatique** du fichier YAML généré.
- **Organisation des fichiers** dans des sous-dossiers basés sur le nom de l'entité (ex: `carrier/bom/link`).
- **Interface utilisateur claire** avec des messages de succès ou d'erreur.

---

## 🛠️ Technologies Utilisées

Le projet utilise les technologies suivantes pour créer l'application :

- **Spring Boot** : Framework backend utilisé pour la création de l'application.
- **Thymeleaf** : Moteur de template pour générer le contenu HTML dynamique.
- **Bootstrap 5** : Framework CSS pour rendre l'interface utilisateur moderne et réactive.
- **Java 23** : Langage utilisé pour la logique métier et le backend.
- **Maven** : Gestionnaire de dépendances utilisé pour compiler et exécuter le projet.

---

## 📦 Prérequis

Avant de commencer, vous devez vous assurer d'avoir les outils suivants installés sur votre machine :

- **Java 23 ou version supérieure** (ou version compatible avec Spring Boot).
- **Maven** (ou un autre gestionnaire de dépendances compatible).
- **IDE** comme IntelliJ IDEA ou Eclipse pour gérer le code.

---

## ⚙️ Configuration

- Dans le fichier src/main/resources/application.properties,
  vous devez spécifier le répertoire où les fichiers YAML générés
  seront enregistrés. Ajoutez la ligne suivante dans ce fichier pour configurer le répertoire de base :
- **base.directory=/chemin/vers/votre/dossier**


