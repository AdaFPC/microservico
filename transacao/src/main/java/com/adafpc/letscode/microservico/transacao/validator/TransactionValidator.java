package com.adafpc.letscode.microservico.transacao.validator;

import com.adafpc.letscode.microservico.transacao.dto.TransactionDto;
import com.adafpc.letscode.microservico.transacao.exception.EmptyparameterValueException;
import com.adafpc.letscode.microservico.transacao.exception.NullTransactionException;
import com.adafpc.letscode.microservico.transacao.exception.UnexpectedParameterException;
import org.apache.commons.lang3.StringUtils;

public class TransactionValidator {
    public void validate(TransactionDto transaction){
        if(transaction.getTransactionType() == null)
            throw new NullTransactionException();

        switch (transaction.getTransactionType()){
            case DEPOSIT:validateDeposit(transaction);
            break;
            case WITHDRAWAL:validateWithdrawal(transaction);
                break;
            case SEND:
            case RECEIVE:
            case PAYMENT:validateExchange(transaction);
            break;
        }
    }

    private void validateDeposit(TransactionDto transaction){
        if(StringUtils.isNotBlank(transaction.getOriginAccount()))
            throw new UnexpectedParameterException("originAccount");
        if(StringUtils.isBlank(transaction.getDestinationAccount()))
            throw new EmptyparameterValueException("destinationAccount");
    }

    private void validateWithdrawal(TransactionDto transaction){
        if(StringUtils.isNotBlank(transaction.getDestinationAccount()))
            throw new UnexpectedParameterException("destinationAccount");
        if(StringUtils.isBlank(transaction.getOriginAccount()))
            throw new EmptyparameterValueException("originAccount");
    }

    private void validateExchange(TransactionDto transaction){
        if(StringUtils.isBlank(transaction.getOriginAccount()))
            throw new EmptyparameterValueException("originAccount");
        if(StringUtils.isBlank(transaction.getDestinationAccount()))
            throw new EmptyparameterValueException("destinationAccount");
    }


}
