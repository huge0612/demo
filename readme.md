# introduce
this project has two modules:
- `provider-demo` : a normal web service with port 8080, has one mapped path: `/host`
```
    @GetMapping("host")
    public String getHost(HttpServletRequest request){
        String host = request.getHeader("host");
        log.info("your host is : {}", host);
        return "your host is : " + host;
    }
```
- `zuul-server`: zuul proxy server with port 8081 

`application.yaml`:
```
server:
  port: 8081
spring:
  application:
    name: api-gateway
zuul:
  routes:
    demo:
      path: /provider/**
      url: http://127.0.0.1:8080/
  add-host-header: 
  ```
 
# current version test
- spring cloud version: Finchley.SR1

- request provider server directly:
```
$ curl -XGET http://localhost:8080/host
$ your host is : localhost:8080
```
- request through zuul proxy:
```
$ curl -XGET http://localhost:8081/provider/host
$ your host is : 127.0.0.1:8080
```

# last version test
- spring cloud version: Finchley.RELEASE

- request provider server directly:
```
$ curl -XGET http://localhost:8080/host
$ your host is : localhost:8080
```
- request through zuul proxy:
```
$ curl -XGET http://localhost:8081/provider/host
$ your host is : localhost:8080
```
