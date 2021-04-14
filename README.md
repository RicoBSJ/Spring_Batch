# Développez le nouveau Système d’Information de la bibliothèque d’une grande ville, Projet 7, dans le cadre de la formation DA JAVA JEE OPENCLASSROOMS

## Contexte

    Vous travaillez au sein de la Direction du Système d’Information (DSI) de la mairie d’une grande ville, sous la direction de Patricia, la responsable du service. La DSI est en charge de tous les traitements numériques pour la mairie et les structures qui lui sont rattachées, comme la gestion du site web de la ville par exemple. À ce titre, Patricia est contactée par le service culturel de la ville qui souhaite moderniser la gestion de ses bibliothèques. John, architecte logiciel, sera chargé de la validation technique du projet.
    Nous souhaitons confier à la DSI la création d’un ensemble d’outils numériques pour les différents acteurs des bibliothèques de la ville. Voici la liste des tâches qui me sont confiées :

    Développer UNE API Web : cette application permettra aux usagers de la bibliothèque d’avoir accès aux fonctionnalités suivantes :

    ⁃	S’enregistrer comme utilisateur ;
    ⁃	Se connecter à l’application en tant qu’utilisateur inscrit ;
    ⁃	Rechercher des ouvrages et voir le nombre d’exemplaires disponibles ;
    ⁃	De Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines ;
    ⁃	De Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

    Développer une Application web Batch  pour des traitements automatisés (mails de relance).

## Les fonctionnalités :

    F1 : Créer un utilisateur, via son email et un mot de passe;

    F2 : Loguer un utilisateur existant tout en faisant appel au token de Spring Security afin de garantir un accès sécurisé;

    F3 : Rechercher des ouvrages et voir le nombre d’exemplaires disponibles;

    F4 : Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines;

    F5 : Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

## Choix techniques retenus

	- API web en REST ou en SOAP (à voir avec le développeur): les clients (site web, batch, logiciel pour les personnels, application mobile) communiqueront à travers une API web. Factorisation de la logique métier.
	- Application web avec un framework MVC (Spring MVC, Struts, …)
	- Packaging avec Maven

	Pour l’application mobile et le logiciel des personnels, une autre réunion sera organisée.

	À noter : Dès la release 1.0, les actions de création d’un prêt et retour d’un prêt seront implémentés même si elles ne seront utilisées par le logiciel pour les personnels uniquement à la release 2.0.

## Spécificités

Les outils utilisés pour le développement

	Cette application a été développée avec :
	
	- IntelliJ IDEA 2021.1 (Ultimate Edition - Build #IU-211.6693.111, built on April 6, 2021)
	- Apache Maven 3.6.3
	- Java 8 (version 1.8 Update 251)
	- Tomcat version 9.0.39
	- PostgreSql 12 (version 10.12 - 10.14)
	- Hibernate ORM (version hibernate-release-5.2.4.Final)
	- Spring Boot version 2.4.3
	- Spring Security version 2.4.1
	- Spring MVC version 5.3.4
	- Bootstrap version

Les étapes de déploiement de l'application

	1/Vous devez au-préalable télécharger et installer :
	
	- Java sur https://www.java.com/fr/download/
	- Le JDK sur https://www.oracle.com/fr/java/technologies/javase/javase-jdk8-downloads.html
	- Apache Maven sur https://maven.apache.org/download.cgi (n'oubliez pas d'ajouter la variable d'environnement d'Apache au "Path")
	- Apache Tomcat sur https://tomcat.apache.org/download-90.cgi
	- PostgreSQL sur https://www.postgresql.org/download/
	- Hibernate sur https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.4.10.Final/hibernate-release-5.4.10.Final.zip/download
	- Dézippez le package "PBiblio_Api_AUBRUN_Eric"
	
	2/Ceci fait, vous devez lancer pgAdmin4 :
	
	- Voici le chemin : /Library/PostgreSQL/12/
	- Dans la base de données, créez un utilisateur "postgres", attribuez lui le mot de passe "postgres"
	- A partir de la base de données, ouvrez l'éditeur de script et exécutez le fichier "PBiblio_Api_03_Script_SQL_Creation_Base_De_Donnees.sql" que vous trouverez dans le package
	- Pour alimenter la base de données, vous devez exécuter à partir de l'emplacement "Tables" le fichier "PBiblio_Api_04_Script_SQL_Jeu_De_Donnees.sql"
	
	3/A partir du terminal
	
	- Ouvrez votre terminal de commande, tapez cd et copiez le chemin d'accès à l'application : ............Faites "ENTRER"
	- Une fois placé dans le chemin de l'application, tapez "mvn package"
	- Rendez-vous dans le chemin suivant : library-exposition\target
	- Copiez le fichier "library-exposition.war" généré par l'étape précédente
	- Rendez-vous dans le dossier apache-tomcat-9.0.30\webapps\ et collez "library-exposition.war"
	
	4/Démarrage de Tomcat
	
	Sur Mac, la démarche est la suivante :
	- Ouvrez le terminal
	- Tapez : "sudo su", ce qui a pour effet de vous donner tous les droits en lecture et écriture
	- Rendez-vous dans le dossier de Tomcat "apache-tomcat-9.0.30\" et tapez : "ls -l"
	- Tapez "sudo chmod -R 755 apache-tomcat-9.0.30\", rendez-vous dans "\bin" et tapez "./startup.sh"
	- Si Tomcat démarre, vous devez obtenir à l'affichage quelque chose de semblable à ceci :
	- Using CATALINA_BASE:   /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_HOME:   /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_TMPDIR: /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30/temp
	- Using JRE_HOME:        /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home
	- Using CLASSPATH:       /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30/bin/bootstrap.jar:/Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30/bin/tomcat-juli.jar
	- Tomcat started.

Le lancement de l'application

    - Ouvrez votre navigateur Internet et tapez "http://localhost:8080/library_exposition_war_exploded/" pour lancer l'application

Pour arrêter Tomcat

    - Pour arrêter Tomcat, tapez "./shutdown.sh", votre affichage devrait ressembler à ceci :
	- Using CATALINA_BASE:   /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_HOME:   /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_TMPDIR: /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30/temp
	- Using JRE_HOME:        /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home
	- Using CLASSPATH:       /Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30/bin/bootstrap.jar:/Users/ricobsj/intellij-workspace/Servers/apache-tomcat-9.0.30/bin/tomcat-juli.jar

## Auteur

Rico BSJ