# Application with client

```bash
mvn clean package
```
```bash
$ asadmin deploy --retrieve . ear/target/helloworld.ear 
Application deployed with name helloworld.
Command deploy executed successfully.
```
Client jar helloworldClient.jar gets generated in the directory specified.

```bash
$ appclient -jar helloworldClient.jar
My Bean going to say hello
Appclient saying Hello World!
```
