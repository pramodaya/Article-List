# list-article


## SPRING | REST-API | SPRING-SECURITY | POSTGRESQL


### - Postgress database table 'article'

<img width="553" alt="Screenshot 2022-12-28 at 01 11 35" src="https://user-images.githubusercontent.com/19555470/209735466-30e18eb4-392d-41af-8063-7fdb29bc92c9.png">


This application contains 3 api's

Use the following credentials to log in ( 2 roles | Only the user role 'ADMIN' can access '/statistic' end point)

User
- username: "pramodaya"
- password: "password"

Admin
- username: "john"
- password: "password"


### - Get article list
Method - GET
http://localhost:8080/api/v1/article
This will return follwowing result with success code 200.

<img width="1391" alt="Screenshot 2022-12-28 at 00 50 11" src="https://user-images.githubusercontent.com/19555470/209734740-5d9faffc-d2fd-41c2-9fee-2724bc26f8ca.png">



### - Add article
Method - POST
http://localhost:8080/api/v1/article/add
This will return following status code 200 if succeeded.

<img width="1375" alt="Screenshot 2022-12-28 at 00 57 18" src="https://user-images.githubusercontent.com/19555470/209734772-5856c83b-6ad9-4092-b92a-9011272f6962.png">


### - Get statistics
Method - GET
http://localhost:8080/api/v1/article/statistic
This will return following result if the user is not an admin:

<img width="1356" alt="Screenshot 2022-12-28 at 01 01 32" src="https://user-images.githubusercontent.com/19555470/209734841-3731a060-7f7b-45a9-a654-5ce9d95d9cfd.png">


If the validation is succeeded with spring security it'll give following result:

<img width="1252" alt="Screenshot 2022-12-28 at 01 29 45" src="https://user-images.githubusercontent.com/19555470/209736235-b23f97b2-c7ad-4522-8ac0-30343cdf028a.png">

<img width="1373" alt="Screenshot 2022-12-30 at 20 49 33" src="https://user-images.githubusercontent.com/19555470/210103283-3aa80bf3-ce6c-40e4-a57f-932bc4dd8bc5.png">



### Question
Create a secured restful API to create and list articles. To create an article the user should provide a title, author, content and the date published. All the properties are mandatory. The title should not exceed 100 characters and the publishing date should be provided in ISO 8601 format. The endpoint for the article list should return paginated results.

Additionally, you are required to develop an endpoint for statistics that would be accessible only by admins. The endpoint should return the count of published articles on daily bases for the last 7 days.
