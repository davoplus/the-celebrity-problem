# the-celebrity-problem
Solution for THE CELEBRITY PROBLEM for Globant

## Installation
1. Just download or clone this source code (git clone https://github.com/davoplus/the-celebrity-problem.git ). 
1. In your download folder (or local repository), type in your console **cd the-celebrity-problem**.
1. Then you will need to build this code with the command **mvnw clean install**.
1. After that, you must type **java -jar target/the-celebrity-problem-0.0.1-SNAPSHOT.jar**.
1. Finally, you will see Spring Boot init screen.

## Usage
After the installation, you will see on your console spring-shell prompt (**shell:>**).
Here you can type:

**add-person**
* This command will Add a new Person.

**add-relation**
* This command will Add a new Relation.

**find-celebrities**
* This command Find the Celebrity(ies) using the relations list of each Person added. This approach can return one or more celebrities.

**find-celebrities-by-relations**
* This command Find the Celebrity(ies) using the relations list recursively from source person. This approach can return one o more celebrities.

**find-celebrity-by-relations**
* This command Find the Celebrity using the relations list recursively from source person. This approach just return one celebrity.

## Examples
* shell:>add-person a
* The Person was added
* shell:>add-person b
* The Person was added
* shell:>add-person c
* The Person was added
* shell:>add-person d
* The Person was added
* shell:>add-relation a b
* The Relation was added
* shell:>add-relation b a
* The Relation was added
* shell:>add-relation a c
* The Relation was added
* shell:>add-relation a d
* The Relation was added
* shell:>add-relation b c
* The Relation was added
* shell:>add-relation b d
* The Relation was added
* shell:>find-celebrities
* The Celebrity(ies) name(s) is(are) C,D
* shell:>find-celebrity-by-relations a
* The Celebrity(ies) name(s) is(are) C
* shell:>find-celebrities-by-relations a
* The Celebrity(ies) name(s) is(are) C,D

## Help
If you need help about the names of the commands you can type:

help

If you need help about a concrete command you can type:

help ** command_name **

For example: help add-relation

* David Alejandro Caicedo De La Cruz
* david.caicedo@globant.com