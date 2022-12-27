# list-article


## SPRING | REST-API | SPRING-SECURITY
This contains 3 api's

Use the following credentials to log in ( 2 roles | Change the user role 'ADMIN' to access '/statistic' end point) 

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a

 >spring.security.user.name = pramodaya
 >spring.security.user.password = password
 >spring.security.user.roles = USER

- Get articles list
- Add article
- Get statistics - only admin could access

### - Get article list
Method - GET
http://localhost:8080/api/v1/article
This will return follwowing result with success code 200.

<img width="1391" alt="Screenshot 2022-12-28 at 00 50 11" src="https://user-images.githubusercontent.com/19555470/209734740-5d9faffc-d2fd-41c2-9fee-2724bc26f8ca.png">



### - Add article
Method - POST
http://localhost:8080/api/v1/article/add
This will return follwowing status code 200 if succeeded.

<img width="1375" alt="Screenshot 2022-12-28 at 00 57 18" src="https://user-images.githubusercontent.com/19555470/209734772-5856c83b-6ad9-4092-b92a-9011272f6962.png">


### - Get statistics
Method - GET
http://localhost:8080/api/v1/article/statistic
This will return follwowing result if the user is not an admin:

<img width="1356" alt="Screenshot 2022-12-28 at 01 01 32" src="https://user-images.githubusercontent.com/19555470/209734841-3731a060-7f7b-45a9-a654-5ce9d95d9cfd.png">


If the validation is succedded with spring security it'll give following result:

<img width="1180" alt="Screenshot 2022-12-28 at 00 57 32" src="https://user-images.githubusercontent.com/19555470/209734790-4b17d2ef-70ad-4b2d-86eb-b8c4032d1a05.png">

