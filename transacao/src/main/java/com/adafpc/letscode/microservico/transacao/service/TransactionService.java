package com.adafpc.letscode.microservico.transacao.service;

import com.adafpc.letscode.microservico.transacao.dto.TransactionDto;
import com.adafpc.letscode.microservico.transacao.exception.BadAuthorizationException;
import com.adafpc.letscode.microservico.transacao.mapper.TransactionMapper;
import com.adafpc.letscode.microservico.transacao.model.Transaction;
import com.adafpc.letscode.microservico.transacao.repository.TransactionRepository;
import com.adafpc.letscode.microservico.transacao.validator.TransactionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final TransactionValidator validator = new TransactionValidator();


    public Long executeTransaction(String authentication, TransactionDto transaction){
        validator.validate(transaction);

        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.AUTHORIZATION, authentication);
        HttpEntity<String>entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> authToken = restTemplate.postForEntity("http://127.0.0.1:9999/api/autenticacao/login",entity, String.class, (Object) null);

        if(authToken.getStatusCode().equals(HttpStatus.ACCEPTED)){

           Transaction transactionModel = TransactionMapper
                .INSTANCE
                .toModel(transaction)
                .withToken(authToken.getBody());

        return transactionRepository.save(transactionModel).getId();

        }


        throw new BadAuthorizationException();
    }


}
