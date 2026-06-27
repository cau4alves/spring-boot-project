package br.com.caua.spring_boot_project.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String helloGet() {
        return "hello Get";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String helloPost() {
        return "hello Post";
    }
}
