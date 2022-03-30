package com.postgres;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class Controller {


    @GetMapping
    public String GetHello() {
        return("GET hello world");
    }
    @PostMapping
    public String PostHello() {
        return("POST hello world");
    }
    @PutMapping
    public String PutHello() {
        return("PUT hello world");
    }

    @PatchMapping
    public String PatchHello(){
        return ("PATCH hello world");
    }
}