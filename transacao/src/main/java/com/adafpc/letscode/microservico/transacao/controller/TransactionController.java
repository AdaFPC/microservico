package com.adafpc.letscode.microservico.transacao.controller;

import com.adafpc.letscode.microservico.transacao.dto.TransactionDto;
import com.adafpc.letscode.microservico.transacao.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/transacao")
@Slf4j
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void executeTransaction(@RequestHeader("Authorization") String authentication,
                                   @RequestBody TransactionDto transaction,
                                   HttpServletResponse response){
        response.addHeader("x-letscode-transactionId",
        transactionService.executeTransaction(authentication, transaction).toString()
        );
    }

    @ExceptionHandler({HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleNotFound(){
        log.info("Lidando com o erro");

    }
}
