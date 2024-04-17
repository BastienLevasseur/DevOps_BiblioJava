# DevOps_BiblioJava 

![test badge](https://github.com/BastienLevasseur/DevOps_BiblioJava/actions/workflows/maven.yml/badge.svg)

Couverture de code : 
![jacoco badge](.github/badges/jacoco.svg)
![jacoco badge branch](.github/badges/branches.svg)


Le package dataFrame vise à traiter simplement et efficacement un ensemble de données. Il permet de créer, afficher et
manipuler des dataFrames tout comme les dataFrames de la bibliothèque Pandas de Python tout en fournissant des analyses
statistiques.

Le but de ce projet est de fournir en Java une partie des fonctionnalités offertes par la bibliothèque Pandas.

## Features

Nous fournissons plusieurs fonctionnalités dans notre bibliothèque; ci-dessus la liste de ces fonctionnalités.

* Création d'un dataFrame
* 
Nous fournissons deux méthodes pour créer un nouveau DataFrame :

    -DataFrame(List<K> index, List<L> label, List<List<V>> values) : construit un Dataframe à partir de listes d'index, de label et de liste de valeurs.
    -DataFrame(String filename, char delimmiter) : construit un Dataframe à partir d'un nom fichier CSV et de son délimiteur.

* Affichage d'un dataFrame


Nous fournissons plusieurs méthodes permettant d'afficher un DataFrame :

    -toString : Affiche tout le contenu d'un DataFrame
    -toStringFirstXElements(int nbLinesToWrite) : Affiche seulement les nbLinesToWrite premières lignes.
    -toStringLastXElements(int nbLinesToWrite) : Affiche seulement les nbLinesToWrite dernières lignes.

* Séléction dans un dataFrame

Nous fournissons plusieurs méthodes permettant de construire un nouveau DataFrame en sélectionnant des lignes et colonnes :

    - constructNewDataFrameWithSelectingRows(List<K> indexList) : crée un nouveau Dataframe en sélectionnant uniquement les lignes ayant leur index dans la liste d'index passé en paramétre.
    - constructNewDataFrameWithSelectingColumns(List<K> labelList) : crée un nouveau Dataframe en sélectionnant uniquement les colonnes ayant leur label dans la liste de label passé en paramétre.
    - constructNewDataFrameWithSelectingValuesOfColumns(L label, double min, double max) : crée un nouveau DataFrame en sélectionnant uniquement les lignes où la valeur de la colonne passé en paramètre est dans l'intervalle des paramètres [min; max].

* Statistiques sur un dataFrame

Nous fournissons plusieurs méthodes pour effectuer des statistiques sur une colonne d'un Dataframe :

Les méthodes suivantes s'appliquent uniquement à des colonnes comportants des nombres

    - Trouver le minimum : getMin(L label)
    - Trouver le maximum : getMax(L label)
    - Calculer la moyenne : getAverage(L label)
    - Calcler la somme : getSum(L label)
    - Calculer la somme en valeur absolue : getAbsolute(L label)
    - Calculer le produit : getProduct(L label)

La méthode suivante s'applique à toutes les colonnes

    - Compter le nombre de cases non vide : getCount(L label)




## Choix des outils

Comme indiqué dans l'introduction, nous avons développé notre bibliothèque en Java et utilisé la version 4 de JUnit
pour les tests unitaires. Nous avons également utilisé Maven afin de construire les différentes phases de notre projet
ainsi que Jacoco pour l'évaluation de la couverture du code.

## Description du workflow Git

Nous avons plusieurs fichiers .yml pour gérer l'intégration continue (situés dans .github/workflows)
(Note : comme ceci est un projet pour l'université nous avons fait beaucoup de tests pour comprendre les actions et autres)

*maven.yml* : situé dans la branche main, ce workflow prend sa base dans le workflow "Java CI with Maven" proposé par Github. Il ne s'active que sur les push et pull_request de main.
Ses différents jobs sont : 
* test-and-coverage : sert à lancer les tests, générer le rapport de couverture de code, l'upload en tant qu'artéfact github (pour stocker les données), générer le badge associé (action provenant d'un autre utilisateur GitHub) et commit le fichier du badge pour qu'il soit affiché plus tard dans le README.md.
* build (besoin de test-and-coverage) : permet générer le package en évitant de refaire les tests, et met en cache les informations. 
* gh-pages (besoin de test-and-coverage) : on utilise mvn site pour construire le site, qui va aussi contenir le README, la Javadoc et le rapport de couverture et les pages seront construites et uploadés en artéfact.
* deploy-pages (besoin de test-and-coverage) : utilise un token pour pouvoir configurer les déployer les pages.
* build-and-publish (besoin de build) : récupère le cache de build, se connecte à Docker, construit et pousse l'image dessus.

*test.yml* : situé dans toutes les branches sauf main (à la base), il s'active sur les push et pull-request de toutes les branches sauf main.
Ses différents jobs sont : 
* test-and-coverage : identique à maven.yml

*build-and-deploy.yml* : situé dans develop (à la base), il s'active sur les push et pull-request de develop. Il appelle test.yml. Il permet de déployer sur github pages depuis develop car on voulait tester la bonne mise en place de la documentation.
Ses différents jobs sont :
* test-and-coverage : appelle test.yml
* gh-pages (besoin de test-and-coverage) : idem maven.yml
* deploy-pages (besoin de test-and-coverage) : idem maven.yml

## Feedback

Nous avons trouvé le projet intéressant et enrichissant : il nous a permis de mettre en oeuvre les techniques et connaissances vu en DevOps tout au long du semestre. Cela nous a permis d'apprendre de nouvelles notions tel que la mise en place d'un Worflow Git ou encore l'utilisation des Pulls Requests pour merge les branches.

Concernant les difficultés, nous avons pris du temps pour mettre en place un Workflow fonctionnel, pour organiser le Git et pour nous organiser entre nous pour le développement 

Nous sommes dans l'ensemble satisfait de notre collaboration et de notre production.
