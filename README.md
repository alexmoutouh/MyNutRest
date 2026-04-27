# MyNutRest
  
MyNutRest is a Spring Boot (Java 25) REST API designed with hexagonal architecture. It handles nutrition and fitness.  
It also acts as an MCP server (with Spring AI).  
  
To run locally the server :  
  
```bash
./mvnw spring-boot:run
```
  
Before calling an endpoint, you need to :  
- start the database  
- configure and start the server on which your llm is running  
  
To test if everything is running well, you can do :  
  
```bash
curl -X POST "{base_url}/my-nut/api/v1/user/id/1/nut/scan" -F "image=@/path/to/image.jpg" -F "grams=150" -v
```
  