# ARTICLE LIST 


## SPRING | REST-API | SPRING-SECURITY | POSTGRESQL

### QUESTION
Create a secured restful API to create and list articles. To create an article the user should provide a title, author, content and the date published. All the properties are mandatory. The title should not exceed 100 characters and the publishing date should be provided in ISO 8601 format. The endpoint for the article list should return paginated results.

Additionally, you are required to develop an endpoint for statistics that would be accessible only by admins. The endpoint should return the count of published articles on daily bases for the last 7 days.


### ANSWER

1 APIs are restricted with the spring security.

2 Authorized user's can create Articles.

### - Postgress database table 'article'

<img width="553" alt="Screenshot 2022-12-28 at 01 11 35" src="https://user-images.githubusercontent.com/19555470/209735466-30e18eb4-392d-41af-8063-7fdb29bc92c9.png">


This application contains 3 api's

Use the following credentials to log in ( 2 roles | Only the user role 'ADMIN' can access '/statistic' end point)
Check application.properties file

User
- username: "pramodaya"
- password: "password"

Admin
- username: "john"
- password: "password"


### - Get article list - Paginated
Method - GET
http://localhost:8080/api/v1/article
This will return follwowing result with success code 200.

<img width="1336" alt="Screenshot 2023-01-08 at 20 08 58" src="https://user-images.githubusercontent.com/19555470/211211957-807fa207-b372-48bf-bf66-e69314a04390.png">


### - Add article
Method - POST
http://localhost:8080/api/v1/article/add
This will return following status code 200 if succeeded.

<img width="1434" alt="Screenshot 2022-12-31 at 01 16 46" src="https://user-images.githubusercontent.com/19555470/210117486-6c09cee9-51b8-4b7a-8e19-b05426ce7f2f.png">


### - Get statistics
Method - GET
http://localhost:8080/api/v1/article/statistic
This will return following result if the user is not an admin:

<img width="1356" alt="Screenshot 2022-12-28 at 01 01 32" src="https://user-images.githubusercontent.com/19555470/209734841-3731a060-7f7b-45a9-a654-5ce9d95d9cfd.png">


If the validation is succeeded with spring security it'll give following result:

<img width="1252" alt="Screenshot 2022-12-28 at 01 29 45" src="https://user-images.githubusercontent.com/19555470/209736235-b23f97b2-c7ad-4522-8ac0-30343cdf028a.png">

<img width="1429" alt="Screenshot 2022-12-31 at 01 17 11" src="https://user-images.githubusercontent.com/19555470/210117525-69831aff-b58c-4239-ab69-dbe0716b31fd.png">

