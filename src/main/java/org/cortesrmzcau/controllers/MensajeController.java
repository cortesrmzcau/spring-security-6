package org.cortesrmzcau.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class MensajeController {
    @GetMapping(value = "/mensaje")
    public ResponseEntity<Object> mensaje() {
        return ResponseEntity.status(200).body("hola");
    }
}
