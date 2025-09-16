package com.daoqonq1408.workshopbesql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
public class MainController {

    @GetMapping("")
    public ResponseEntity<String> main() {
        return ResponseEntity.ok("Hello World");
    }
}
