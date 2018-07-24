# the-celebrity-problem
Solution for THE CELEBRITY PROBLEM for Globant

## Installation
1. Just download or clone this source code (git clone https://github.com/davoplus/the-celebrity-problem.git ). 
1. In your download folder (or local repository), type in your console **cd the-celebrity-problem**.
1. Then you will need to build this code with the command **mvnw clean install -DskipTests**.
1. After that, you must type **java -jar target/the-celebrity-problem-0.0.1-SNAPSHOT.jar**.
1. Finally, you will see Spring Boot init screen.

## Usage
After the installation, you will see on your console spring-shell prompt (**shell:>**).
Here you can type:

add-person
This command will Add a new Person.

add-relation
This command will Add a new Relation.

find-celebrity
This command Find the Celebrity usin the relations list of each Person added. This approach can return one or many celebrities.

find-celebrity-by-relations
This command Find the Celebrity usin the relations list recursively. This approach just return 1 celebrity.