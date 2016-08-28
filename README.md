# myRetailProducts

##PreRequisite: <br />
1. Has a running instance of mongoDb. The host for mongoDb can be customized in application.properties file. <br />
  1. To download and setup mongodb on linux: <br />
       1. `wget https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-amazon-3.2.9.tgz`
       2. `tar -xvzf ./mongodb-linux-x86_64-amazon-3.2.9.tgz`
       3.  `mkdir -p mongodb`
       4. `mv mongodb-linux-x86_64-amazon-3.2.9 mongodb`
       5. `mkdir -p mongodb/data/db`
  2. To start mongodb:
       1. `cd mongodb`
       2. `./bin/mongod --dbpath ./data/db`
2. Environment: JDK (v1.8), git to get code, mvn to build code. If maven is not present, use mvnw instead of mvn.

##Steps to run: <br />
1. `git clone https://github.com/jyothri/myRetailProducts.git`
2. `cd myRetailProducts`
3. To compile & run tests:  `mvn clean compile test`
4. To start the application and be ready for requests: `mvn spring-boot:run`

### To run analysis for code coverage
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent test -Dmaven.test.failure.ignore=true <br />

##This is an attempt to solve the following case study - 

Build an application that performs the following actions:

1. Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number.

Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793)
Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}

2. Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from api.target.com, but let’s just pretend this is an internal resource hosted by myRetail)  o Example:

https://api.target.com/products/v3/13860428?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz

3. Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.  

4. BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.

##to make it production ready :-

1. Resilience - retry mechanism, timeout
2. Performance - cache the results with cache invalidation
3. Security - authentication and authoraization
