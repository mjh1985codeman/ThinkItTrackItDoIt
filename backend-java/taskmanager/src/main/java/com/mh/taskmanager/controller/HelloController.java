package com.mh.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

//tells Spring this class handles HTTP API requests.
@RestController
public class HelloController {
    // URL path for GET requests.
    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        // Map.of is a super simple way to return JSON.
        return Map.of("message", "Hello, world!");
    }
}
