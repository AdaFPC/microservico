package com.adafpc.letscode.microservico.autentificacao.service;

import com.adafpc.letscode.microservico.autentificacao.exception.UserNotFoundException;
import com.adafpc.letscode.microservico.autentificacao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

@Service
@Slf4j
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    public String authenticateUser(String base64password){

        String decodedPassword = new String(
                Base64
                        .getDecoder()
                        .decode(base64password
                                .replace("Basic ", "")
                        )
        );

        String[] loginAndPassword = decodedPassword.split(":");

        boolean userFound = userRepository.existsByLoginAndPassword(loginAndPassword[0], loginAndPassword[1]);

        log.info("user {} {} found on database",loginAndPassword[0], (userFound ? "was" : "not"));
        if(!userFound) throw new UserNotFoundException(loginAndPassword[0]);

        return UUID.randomUUID().toString();
    }
}
