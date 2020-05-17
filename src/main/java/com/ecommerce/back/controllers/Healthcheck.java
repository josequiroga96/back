package com.ecommerce.back.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/undefined")
public class Healthcheck {

    @GetMapping("")
    public ResponseEntity<String> getAllProducts() {
        return new ResponseEntity<>("This server is working!", HttpStatus.OK);
    }
}
