AOP Sample
---

This is a sample of AOP, I used dummy methods to learn how AOP works, and I used the following technologies:
* Spring Boot 1.5.2.RELEASE
* AOP

How to run?
---

1. Compile the project with the following command:

   ```mvn clean install```

2. The project is a Spring Boot Application, so you can run inside of your ide or from terminal with the following command:

   ```mvn spring-boot:run```

3. In the console you will see the output of the AOP methods.

Rest endpoints
---

* **Request:** Find default data
  
  ```
  url    : http://localhost:8080/sample-aop/person/default-data
  method : GET
  ```
  
* **Request:** Add person
    
    ```
    url    : http://localhost:8080/sample-aop/person/{name}/add
    method : PUT
    ```

* Or you can run from terminal with the following command:

    ```
    curl -X GET http://localhost:8080/sample-aop/person/default-data
    curl -X PUT http://localhost:8080/sample-aop/person/{name}/add
```
