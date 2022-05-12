package com.adafpc.letscode.microservico.autentificacao.controller;

import com.adafpc.letscode.microservico.autentificacao.exception.UserNotFoundException;
import com.adafpc.letscode.microservico.autentificacao.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autenticacao")
@Slf4j
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/login")
    public String login(@RequestHeader("Authorization") String authentication){
         return authenticationService.authenticateUser(authentication);
    }

    @ExceptionHandler({UserNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleNotFound(){
        log.info("Lidando com o erro");

    }

}
