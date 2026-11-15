# Tournoi du dilemme du prisonnier itéré — HAI716I

**HAI716I Projet 2 (partie 1)**  
**Auteur :** Zeina ABDEL SATTAR 
**Langage :** Java
**Version :** openjdk version "21.0.12.1" 2026-08-

## Prérequis techniques

- JDK : 21
- Java : 21
- Aucune dépendance externe.

---

## 1. Présentation du projet

Ce projet consiste à développer un moteur de tournoi du dilemme du prisonnier itéré. Plusieurs stratégies s'affrontent au cours de parties successives, et leurs performances sont comparées à travers un classement général.

Le projet reprend le principe du tournoi d'Axelrod : chaque stratégie joue contre toutes les autres, et les scores obtenus lors des différentes rencontres sont additionnés pour déterminer le classement final.

Le programme permet également d'étudier l'influence de différentes modifications des règles du jeu, notamment le bruit et l'horizon temporel inconnu.

## 2. Structure du projet

```text
.
├── src/
│   ├── AxelrodTournament.java
│   ├── Decision.java
│   ├── Game.java
│   ├── Main.java
│   ├── Player.java
│   ├── Score.java
│   ├── Strategy.java
│   ├── StrategyType.java
│   └── strategies/
│       ├── AlwaysCooperate.java
│       ├── AlwaysDefect.java
│       ├── Joss.java
│       ├── Majority.java
│       ├── Random.java
│       ├── Tester.java
│       └── TitForTat.java
```

### Rôle des principales classes

- `Main` : point d'entrée du programme et sélection de la configuration du tournoi.
- `Game` : gère une partie entre deux joueurs, les décisions successives, l'application éventuelle du bruit et le calcul des scores.
- `Player` : représente un joueur et conserve son historique de décisions ainsi que son score.
- `Score` : calcule les gains obtenus par les joueurs. (score Matrix)
- `Strategy` : définit l'interface commune aux stratégies.
- `StrategyType` : enumeration identifiant les différentes stratégies pour faciliter la representation.
- `AxelrodTournament` : organise les rencontres entre les stratégies et établit le classement final.

## 3. Règles du jeu

Deux joueurs choisissent simultanément entre deux décisions :

- **COOPERATE — Coopérer**
- **DEFECT — Faire défection**

Les gains sont attribués selon la matrice suivante :

| | Joueur 2 : C | Joueur 2 : D |
|---|---:|---:|
| **Joueur 1 : COOPERATE** | 3, 3 | 0, 5 |
| **Joueur 1 : DEFECT** | 5, 0 | 2, 2 |

Chaque joueur connaît les décisions précédentes de son adversaire, mais ne connaît pas sa décision courante au moment de choisir la sienne. Il ne peut l'utiliser qu'à travers la strategy choisi.

## 4. Stratégies implémentées

Sept stratégies sont disponibles dans le programme.

### Stratégies du cours

| Stratégie | Principe |
|---|---|
| ALL-D (`AlwaysDefect`) | Joue toujours DEFECT, indépendamment de l'historique. |
| RANDOM (`Random`) | Choisit aléatoirement entre COOPERATE et DEFECT. |
| TIT-FOR-TAT (`TitForTat`) | Coopère au premier tour, puis reproduit la dernière décision de son adversaire. |
| TESTER (`Tester`) | Joue DEFECT au premier tour. Selon la réaction de l'adversaire, adopte TIT-FOR-TAT ou répète la séquence COOPERATE, COOPERATE, DEFECT. |
| JOSS (`Joss`) | Suit TIT-FOR-TAT, mais remplace périodiquement une coopération par une défection. |

### Stratégies supplémentaires

| Stratégie | Principe |
|---|---|
| ALL-C (`AlwaysCooperate`) | Joue toujours COOPERATE. |
| MAJORITY (`Majority`) | COOPERATE si l'adversaire a coopéré plus souvent qu'il n'a fait défection ; sinon, DEFECT.|

### Compilation

Depuis la racine du projet :

```bash
javac -d out src/*.java src/strategies/*.java
```

### Exécution

Les commandes suivantes correspondent à l'interface en ligne de commande prévue dans `Main`.

```bash
# Tournoi de base
java -cp out src.Main baseline

# Tournoi avec les sept stratégies
java -cp out src.Main extended

# Tournoi avec 5 % de bruit
java -cp out src.Main noise 0.05

# Tournoi avec une probabilité de continuation de 0.9
java -cp out src.Main horizon 0.9

# Tournoi combinant les deux modifications
java -cp out src.Main custom 0.05 0.9
```

Il est également possible de préciser le nombre maximal de tours :

```bash
java -cp out src.Main extended 100
```

**Attention :** ces commandes doivent correspondre aux arguments effectivement pris en charge par la version finale de `Main.java`.

## 9. Reproductibilité

[À COMPLÉTER]

Indiquer ici la graine aléatoire utilisée et la manière dont elle est transmise aux différents générateurs aléatoires du programme.

Les expériences doivent pouvoir être relancées avec les mêmes paramètres et la même graine afin de reproduire les résultats.

## 10. Journal de bord

Le journal de bord est disponible dans le fichier :

`[logbook.pdf]`

Il contient les choix de conception, les prédictions expérimentales, les résultats obtenus, les difficultés rencontrées et les captures d'écran des différentes étapes du projet.

---