# CaesarChipherService


## My Implementation

* It's built for **SpringBoot 2.4.2**

## Requirement
* Java 11
* Spring Boot
* Gradle
* Swagger API Documentation


## To test API by running it locally you can use attached postman collection.
```
https://github.com/vickhny/CaesarChipherService/blob/main/CaesarCipher.postman_collection.json
```


## REST APIs Endpoints
### Decrypt Cipher Text
```
POST http://localhost:8080/oodle/decrypt
Accept: application/json
Content-Type: application/octet-stream
```


### Encrypt Plain Text (Default offset is 2. It can be configure from application.yml)
```
POST http://localhost:8080/oodle/encrypt
Accept: application/json
Content-Type: application/octet-stream
```



### Get information about system health
```
http://localhost:8080/actuator/health

```

### To view Swagger 2 API docs
```
Run the server and browse to - http://localhost:8080/swagger-ui.html#/caesar-cipher-controller
```

