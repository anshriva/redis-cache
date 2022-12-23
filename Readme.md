### Intro
The code runs simple spring boot application on a configurable port defined in application.properties. 
It also connects to redis server and does crud operation.

run the program using :
```mvn spring-boot:run```

the controller exposed is :
```
http://localhost:8080/healthCheck
http://localhost:8080/data?key=Anubhav
http://localhost:8080/set_data?key=Anubhav&val=10
```

You can change the port from application.properties by changing following value. For example here we change the port to 8999

```server.port:8999```

You can also change the connection string of redis using :
``` redis.connectionString=redis://localhost:6000 ```