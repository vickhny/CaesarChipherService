# CaesarChipherService

* You are trying to eavesdrop on communications between your enemies. You have managed
to intercept their messages and have discovered that they are using a Caesar cipher. You
also have a number of plaintext snippets (“cribs”) that you believe are present in the
plaintext message.

* Your challenge is to write a Java microservice that attempts to crack the Caesar cipher used
by your enemies. It should accept the input as a JSON POST on the path /decrypt.

* Your service will be passed JSON containing:
 1. The encrypted ciphertext.
 2. The list of plaintext snippets, or “cribs”.

* Example input is:
```
POST to /decrypt with a body of:

{
 “ciphertext” : “VJKUKUCUGETGVOGUUCIG”,
 “cribs” : [“THI”, “MES”]
}
```
* The service should return JSON containing the full decrypted plaintext version of the
encrypted text.
An example response might be:
```
{
 “plaintext” : “THISISASECRETMESSAGE”
}
```
## Notes:
* All input and output messages are in upper case, with no spaces.
* The Caesar cipher shift used by you enemies changes between messages, but it is
always the same for a given cipher text.
* Your enemies may be aware of what you are trying to do and may try to confuse
your algorithm, but they are not smart enough to choose another cipher.
* You are certain that all of the cribs provided do appear in the plaintext.


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

