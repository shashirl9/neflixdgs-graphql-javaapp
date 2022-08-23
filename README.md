# neflixdgs-graphql-javaapp
Start GraphQL with Netflix DGS framework and Spring Boot

![img_4.png](img_4.png)

## Launch it with docker
```bash
docker run --rm -it -v $(pwd):/project -w /project -p 9993:9993 maven:3.8.6-openjdk-18 mvn spring-boot:run
```

## Access to web application
http://localhost:9993/graphiql

![img_2.png](img_2.png)

Mutation: 

![img.png](img.png)

H2 Database:

![img_1.png](img_1.png)

Query:

![img_3.png](img_3.png)