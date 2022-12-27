# list-article


## SPRING | REST-API | SPRING-SECURITY
This contains 3 api's

Use the following credentials to log in ( 2 roles | Change the user role 'ADMIN' to access '/statistic' end point) 

 spring.security.user.name = pramodaya
 spring.security.user.password = password
 spring.security.user.roles = USER

- Get articles list
- Add article
- Get statistics - only admin could access

### - Get article list
Method - GET
http://localhost:8080/api/v1/article
This will return follwowing result with success code 200.


### - Add articlee
Method - POST
http://localhost:8080/api/v1/article/add
This will return follwowing status code 200 if succeeded.


### - Get statistics
Method - GET
http://localhost:8080/api/v1/article/statistic
This will return follwowing result if the user is not an admin:

If the validation is succedded with spring security it'll give following result:
