package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
@Slf4j
public class ProviderDemo {
    public static void main(String[] args) {
        SpringApplication.run(ProviderDemo.class);
    }

    @GetMapping("host")
    public String getHost(HttpServletRequest request){
        String host = request.getHeader("host");
        log.info("your host is : {}", host);
        return "your host is : " + host;
    }
}
