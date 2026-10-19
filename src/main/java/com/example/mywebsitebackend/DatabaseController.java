package com.example.mywebsitebackend;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DatabaseController {

	private final JdbcTemplate jdbcTemplate;

    public DatabaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
    @GetMapping("/api/database")
    public Map<String, String> checkDatabase() {
        String databaseName = jdbcTemplate.queryForObject(
            "SELECT DATABASE()", String.class
        );

        return Map.of("database", databaseName);
    }
	
	
}
