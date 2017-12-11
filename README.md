# ScrapBook 1.0

This is a simples website that adds, edit and deletes messages on a scrapbook using PUT, GET, DELETE, POST HTTP methods.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

as follows:

```
Eclipse
Maven
Java
```

### Installing and Running

There is two ways to run this, they are:

Eclipse Project:

```
On eclipse -> Right click on Scrapbook.java -> Run as -> Run Configuration -> Java Application 
```

and then open Arguments TAB and put the code below on VM Arguments

```
-Dspring.profiles.active=local
```

This will execute the code on the local profile and save stuff on H2.
To save it on a DB(postgres in this case) chande local to prod, as:

```
-Dspring.profiles.active=prod
```

Finally hit your browser with


```
localhost:8080/scrapbook
```


*Just remember to check the ports your DB is listening and to have the same table and columns as Message.java

Second way is running the jar file directly, for that:
Find the scrapbook.jar inside the target folder and run a CMD command from that folder:

```
java -jar scrapbook.jar --spring.profiles.active=local
```



## Built With

* [Spring Boot](https://spring.io/docs) - The framework used
* [Angular JS](https://angularjs.org/) - The front-end framework
* [Hibernate](http://hibernate.org/) - Mapping Tool Framework
* [Spring Data](http://projects.spring.io/spring-data/) - Spring-based programming model
* [Bootstrap](https://getbootstrap.com/docs/4.0/getting-started/introduction/) - Another Front-end framework
* [FreeMarker](https://freemarker.apache.org/) - A template engine to generate JAVA text output 



## Authors

* **Matheus Mordost** - *Scrapbook 1.0* - [Raxorpro1](https://github.com/raxorpro1)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
