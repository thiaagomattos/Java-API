
Description:
A Java 17 and Spring Boot 3 project with Maven that consists of a CRUD Rest API for cars with drivers.

Installation:
To install the project, you need to have MongoDB, Java version 17, Maven, and Spring Boot 3 installed on your computer. You also need an API client to run the project; in this case, Postman was used to make the requests.

Usage:
The project includes a CRUD (Create, Read, Update, and Delete) for a microservice for cars, which has an ID, a Brand, a Model, a pilot with a name and age, and the car's manufacturing year. The service does not allow the creation of cars with the same Brand and Model, nor does it allow the same pilot to be associated with more than one car.

To create a car, you need to make a POST request in Postman with the following configuration:

URL: localhost:8080/ms-cars/

JSON format:

{
    "brand": "BMW",
    "model": "X1",
    "pilot":
        {
            "name":"Peter Josh",
            "age": 21
        },
    "year": "2022-03-03"
}
For the GET method, use the following configuration:

URL: localhost:8080/ms-cars/

As a response, you should receive an example like the one below:

{
    "id": "6053dfgn235jcff012m",
    "brand": "BMW",
    "model": "X1",
    "pilot":
        {
            "name":"Peter Josh",
            "age": 21
        },
    "year": "2022-03-03"
}

For the UPDATE method:

URL: localhost:8080/ms-cars/{id}

And for the DELETE method:

URL: localhost:8080/ms-cars/{id}
