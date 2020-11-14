# microservice

## How to Run

This is a step-by-step guide how to run the example:
## Installation
- Java 8
- Docker + docker compose
- Maven
## Build
Change to directory /microservice-demo
Run with 

``` mvn clean package ```

## Run the containers
Change to directory /docker
``` docker-compose build ```
Now you can start the containers using `docker-compose up -d`

You can access:

* The application through Zuul at 

 http://localhost:8080/customer/list

 http://localhost:8080/catalog/list

 http://localhost:8080/order

* The Eureka dashboard at http://localhost:8761/
