package br.com.desafio.restapipagamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DefaultController {

    @GetMapping
    public ResponseEntity<String> ok(){
        return new ResponseEntity<>("OK - " + LocalDateTime.now().toString(), HttpStatus.OK);
    }
}
