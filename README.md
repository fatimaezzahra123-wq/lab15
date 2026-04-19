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

 Architecture
L’application suit une architecture en couches :
MainActivity (UI)
↓
EtudiantService (Logique CRUD)
↓
MySQLiteHelper (SQLite)
↓
Base de données


