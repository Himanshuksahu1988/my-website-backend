package com.example.mywebsitebackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class HelloController {

    @GetMapping("/api/message")
    public Message hello() {
        return new Message(
            "Hello from my website api",
            "My Website",
            "Success"
        );
    }

    @GetMapping("/api/project")
    public Message getProject() {
        return new Message(
            "My Website",
            "React + Spring Boot",
            "In Progress"
        );
    }
    
    @GetMapping("/api/skills")
    public String skills() {
    	
    	return "Java,Selenium,Spring Boot";
    }

    public record Message(String message, String project, String Status) {
    }
}