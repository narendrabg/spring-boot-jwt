package com.example.helloworld.controller;

import com.example.helloworld.dto.HelloWorldBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HelloworldController {

    @GetMapping("/hello")
    public ResponseEntity<HelloWorldBean> helloWorld() {
        //throw new RuntimeException("Unknown error occured..contact helpdesk");
         return ResponseEntity.ok(new HelloWorldBean("Hello world updated"));
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<HelloWorldBean> helloWorldWithParam(@PathVariable String name) {
        return ResponseEntity.ok(new HelloWorldBean("Hello world "+name));
    }
}


