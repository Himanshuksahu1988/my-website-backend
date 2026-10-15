package com.example.mywebsitebackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


@GetMapping("/api/project")
public message getProject() {
    return new message(
        "My Website",
        "React + Spring Boot",
        "In Progress"
    );
}

	
	
	public record message(String message, String project, String Status) {
		
	}
	
}
