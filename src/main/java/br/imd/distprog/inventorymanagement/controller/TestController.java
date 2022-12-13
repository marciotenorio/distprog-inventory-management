package br.imd.distprog.inventorymanagement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping
    public ResponseEntity<Integer> test(){
        return ResponseEntity.ok(port);
    }
}
