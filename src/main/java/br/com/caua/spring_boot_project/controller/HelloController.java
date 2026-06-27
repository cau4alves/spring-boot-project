package br.com.caua.spring_boot_project.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloController {

//    @GetMapping
//    public String hello() {
//        return "hello";
//    }

//    @GetMapping
//    public ResponseEntity<String> hello() {
//        return ResponseEntity.ok("hello");
//    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


}
