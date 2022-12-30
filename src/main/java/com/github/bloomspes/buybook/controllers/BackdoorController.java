package com.github.bloomspes.buybook.controllers;

import java.time.LocalDateTime;

import jakarta.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backdoor")
@Transactional
public class BackdoorController {
    private final JdbcTemplate jdbcTemplate;

    public BackdoorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/setup-database")
    public String setupDatabase() {
        jdbcTemplate.execute("DELETE FROM products");

        createProducts();

        return "OK";
    }

    private void createProducts() {
        LocalDateTime now = LocalDateTime.now();

        jdbcTemplate.update("" +
                        "INSERT INTO products(" +
                        "   id, title, publisher, created_at, updated_at" +
                        ")" +
                        " VALUES(?, ?, ?, ?, ?)",
                1L, "CODE", "Insight", now, now
        );
    }
}
