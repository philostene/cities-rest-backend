# Cities REST Backend

Backend REST fourni pour la réalisation d'une application cliente JavaScript

## Configuration pour le lancement de Tomcat

- Avec le plugin Maven Apache Tomcat : mettre à jour la propriété système *referentiel.db.jdbc.url* dans la configuration du plugin tomcat8-maven-plugin (*pom.xml*) pour pointer sur l'emplacement dans lequel se trouve la base fichier (adapter surtout le répertoire parent de *db/data/referentiel*)
- Dans Eclipse : dans la configuration d'exécution (Run as ...), onglet *Arguments*, ajouter *-Dreferentiel.db.jdbc.url=jdbc:h2:file:~/work/pe-promo2/cities-rest-backend/db/data/referentiel* en adaptant l'emplacement de la base fichier (adapter surtout le répertoire parent de *db/data/referentiel*)

## Prérequis au lancement en ligne de commande

La variable d'environnement *JAVA_HOME* doit être définie et pointer vers le répertoire d'un JDK 7+ (ex. JAVA\_HOME=C:\Outils\JDK1.7.0)

## Lancement en ligne de commande

- Avec Maven si installé : *mvn clean tomcat8:run*
- Avec le Wrapper Maven compris dans le projet : *./mvnw clean tomcat8:run* (Unix) ou *./mvnw.cmd clean tomcat8:run* (Windows)
