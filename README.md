LAB 15 — Android SQLite : Gestion des Étudiants
## 🎥 Démonstration du projet

👉 Cliquez ici pour voir la vidéo :

[Voir la démonstration sur YouTube](https://youtu.be/xeEB68-IXjg)

📌 Description
Ce projet Android implémente une application simple de gestion des étudiants utilisant une base de données locale SQLite.
L’application permet de réaliser les opérations CRUD :
Ajouter un étudiant
Rechercher un étudiant
Supprimer un étudiant
🎯 Objectifs
Comprendre l’utilisation de SQLite dans Android
Implémenter un CRUD complet
Structurer une application en couches
Tester avec Logcat et interface graphique
Analyser la sécurité avec MobSF
🏗️ Architecture
L’application suit une architecture en couches :
MainActivity (UI)
↓
EtudiantService (Logique CRUD)
↓
MySQLiteHelper (SQLite)
↓
Base de données
📂 Structure du projet
projet.ensa.ma.app.lab15
│
├── classes
│   └── Etudiant.java
│
├── service
│   └── EtudiantService.java
│
├── util
│   └── MySQLiteHelper.java
│
└── MainActivity.java
📦 Description des composants
🔹 Etudiant.java
Classe modèle représentant un étudiant :
id : clé primaire auto-incrémentée
nom : nom de l’étudiant
prenom : prénom de l’étudiant

🔹 MySQLiteHelper.java
Gère la base de données SQLite :
Création de la base ecole.db
Création de la table etudiant
Gestion des mises à jour

🔹 EtudiantService.java
Implémente les opérations CRUD :
create() → insertion
findById() → recherche par ID
findAll() → liste complète
delete() → suppression
update() → modification

🔹 MainActivity.java
Interface utilisateur permettant :
Ajouter un étudiant
Chercher par ID
Supprimer un étudiant
