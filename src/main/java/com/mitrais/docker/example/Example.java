package com.mitrais.docker.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping( "/" )
    public String home() {
        return "Hello World!\n";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
    
}
