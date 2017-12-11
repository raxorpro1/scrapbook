# scrapbook
This is a simples website that adds, edit and deletes messages on a scrapbook using PUT, GET, DELETE, POST HTTP methods.

===============
Technologies Used:
Spring Boot
Angular JS
Hibernate/JPA
Spring Data
Bootstrap
=================

Running mode:
1. On eclipse -> Right click on Scrapbook.java -> Run as -> Run Configuration -> Java Application -> Arguments(TAB) and then set the VM Arguments to -Dspring.profiles.active=local
1.1 hit your browser as 'localhost:8080/scrapbook' and keep an eye for the HTTP methods requests=](Firefox prefered)
1.1.1 This should start the database on H2

2. Jar File. Inside the Target Folder there is a Jar File named Scrapbook.jar, Run it on CMD as -> java -jar Scrapbook.jar  --spring.profiles.active=local
2.1 as 1.1, hit your browser with "localhost:8080/scrapbook" (Firefox Prefered)
2.1.1 Also starts in local profile

If 'Local' is changed to 'PROD' it will look up for a SQL connection(But will need your DB to be running with exact columns and table names as Message.java)
Also check the DB port.


*Firefox is prefered since bootstrap is acting strange with other browers(it will not display the pagination and message search by id)
